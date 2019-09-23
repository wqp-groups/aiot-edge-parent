package com.wqp.aiot.edge.stream.task;

import com.wqp.aiot.edge.stream.entity.AiotEdgeSenseConfigEntity;
import com.wqp.aiot.edge.stream.entity.EdgeHeartbeatEntity;
import com.wqp.aiot.edge.stream.stream.netty.ChannelHandlerClient;
import com.wqp.aiot.edge.stream.stream.protof.StreamTransferProtof;
import com.wqp.aiot.edge.stream.stream.protof.StreamTransferTopic;
import com.wqp.common.stream.netty.client.NettyExecutorClient;
import com.wqp.common.stream.netty.core.LocalIdleStateHandler;
import com.wqp.common.stream.netty.core.NettyConf;
import com.wqp.common.util.common.DateUtil;
import com.wqp.common.util.common.JacksonMapperUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *定时采集边缘设备心跳数据上传
 * 默认执行周期：2分钟
 */
@Component
@EnableScheduling
public class DefaultEdgeHeartbeatSchedulingTask implements SchedulingConfigurer {

    @Autowired
    private AiotEdgeSenseConfigEntity aiotEdgeSenseConfigEntity;


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Assert.notNull(aiotEdgeSenseConfigEntity, "边缘设备未正确配置基础参数");
        List<ChannelHandler> ch = new ArrayList<>();
        IdleStateHandler idleStateHandler = new LocalIdleStateHandler(0, 10,0, TimeUnit.SECONDS);
        ChannelHandlerClient handlerClient = new ChannelHandlerClient();
        ch.add(idleStateHandler);
        ch.add(handlerClient);
        NettyConf conf = new NettyConf().setHost(aiotEdgeSenseConfigEntity.getNetty().getHost()).setPort(aiotEdgeSenseConfigEntity.getNetty().getPort()).setFrameDelimiter(StringUtils.isEmpty(aiotEdgeSenseConfigEntity.getNetty().getFrameDelimiter()) ? "$$@$$" : aiotEdgeSenseConfigEntity.getNetty().getFrameDelimiter()).setChannelHandler(ch);

        NettyExecutorClient client = new NettyExecutorClient();
        client.setNettyConf(conf);

        // 注册调度
        scheduledTaskRegistrar.addFixedDelayTask(() -> {
            try {
                process(client);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }, aiotEdgeSenseConfigEntity.getEdgeHeartbeatFrequency());
    }

    private void process(NettyExecutorClient client) throws UnknownHostException {
        Date date = new Date();
        InetAddress inetAddres = InetAddress.getLocalHost();
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        File[] listRoots = File.listRoots();
        long totalDiskSpace = 0, freeDiskSpace = 0, availDiskSpace = 0;
        for (File f:listRoots) {
            totalDiskSpace += f.getTotalSpace();
            freeDiskSpace += f.getFreeSpace();
            availDiskSpace += f.getUsableSpace();
        }
        Map<String, String> cpuInfo = null;
        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("linux")){
            cpuInfo = getLinuxCpuInfo();
        }

        EdgeHeartbeatEntity edgeHeartbeatEntity = new EdgeHeartbeatEntity();
        EdgeHeartbeatEntity.EdgeHeartbeat edgeHeartbeat = new EdgeHeartbeatEntity.EdgeHeartbeat();
        edgeHeartbeat.setEdgeid(aiotEdgeSenseConfigEntity.getEdgeid());
        edgeHeartbeat.setEdgestatus(true);
        edgeHeartbeat.setOsname(os);
        edgeHeartbeat.setOsarch(System.getProperty("os.arch"));
        edgeHeartbeat.setMemorytotal(formatSize(heapMemoryUsage.getInit()));
        edgeHeartbeat.setMemoryused(formatSize(heapMemoryUsage.getUsed()));
        edgeHeartbeat.setMemoryfree(formatSize(heapMemoryUsage.getMax()));
        if(cpuInfo != null){
            edgeHeartbeat.setCpuuserrate(cpuInfo.get("user"));
            edgeHeartbeat.setCpusysrate(cpuInfo.get("system"));
            edgeHeartbeat.setCpuidlerate(cpuInfo.get("idle"));
            edgeHeartbeat.setCpucombinedrate(cpuInfo.get("idle"));
        }
        edgeHeartbeat.setNetip(inetAddres.getHostAddress());
        // windows 环境下仅检测d盘, linux 环境下仅检测当前挂载分区
        edgeHeartbeat.setFiledisktotal(formatSize(totalDiskSpace));
        edgeHeartbeat.setFilediskfree(formatSize(freeDiskSpace));
        edgeHeartbeat.setFilediskavail(formatSize(availDiskSpace));
        edgeHeartbeatEntity.setEdgeheartbeat(edgeHeartbeat);
        edgeHeartbeatEntity.setGathertime(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));

        String origindata = JacksonMapperUtil.object2json(edgeHeartbeatEntity);
        String filename = aiotEdgeSenseConfigEntity.getProductid()+ "_" + aiotEdgeSenseConfigEntity.getEdgeid() + "_HD_" + DateUtil.format(date,"yyyyMMddHHmmss") + ".json";
        StreamTransferProtof.StreamTransferData.Builder builder = StreamTransferProtof.StreamTransferData.newBuilder();
        builder.setTransfertime(DateUtil.format(new Date(), DateUtil.DATE_PATTERN_ONE));
        builder.setEdgeid(aiotEdgeSenseConfigEntity.getEdgeid());
        builder.setOrigindata(origindata);
        builder.setOriginname(filename);
        builder.setOrigintopic(StreamTransferTopic.EDGE_UPLOAD_HEARTBEAT_DATA.getType());

        ByteBuf byteBuf = Unpooled.wrappedBuffer(Unpooled.copiedBuffer(builder.build().toByteArray()), Unpooled.copiedBuffer(client.getNettyConf().getFrameDelimiter().getBytes()));
        client.publish(byteBuf);
    }

    /**
     * 格式化参数
     * @param size
     * @return
     */
    private String formatSize(long size){
        DecimalFormat df = new DecimalFormat("#.00");
        String result;
        if (size < 1024) {
            result = df.format((double) size) + "B";
        } else if (size < 1048576) {
            result = df.format((double) size / 1024) + "K";
        } else if (size < 1073741824) {
            result = df.format((double) size / 1048576) + "M";
        } else {
            result = df.format((double) size / 1073741824) + "G";
        }
        return result;
    }

    /**
     * 获取Linux环境CPU信息
     * @return
     */
    private Map<String,String> getLinuxCpuInfo(){
        InputStreamReader inputs = null;
        BufferedReader buffer = null;
        Map<String, String> map = new HashMap<>();
        try {
            inputs = new InputStreamReader(new FileInputStream("/proc/stat"));
            buffer = new BufferedReader(inputs);
            String line;
            while (true) {
                line = buffer.readLine();
                if (line == null) {
                    break;
                }
                if (line.startsWith("cpu")) {
                    StringTokenizer tokenizer = new StringTokenizer(line);
                    List<String> temp = new ArrayList<String>();
                    while (tokenizer.hasMoreElements()) {
                        String value = tokenizer.nextToken();
                        temp.add(value);
                    }
                    map.put("user", temp.get(1));
                    map.put("nice", temp.get(2));
                    map.put("system", temp.get(3));
                    map.put("idle", temp.get(4));
                    map.put("iowait", temp.get(5));
                    map.put("irq", temp.get(6));
                    map.put("softirq", temp.get(7));
                    map.put("stealstolen", temp.get(8));
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                buffer.close();
                inputs.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return map;
    }

//    private static void initSigar() {
//        SigarLoader sigarLoader = new SigarLoader(Sigar.class);
//        try {
//            String libraryName = sigarLoader.getLibraryName();
//            URL url = DefaultEdgeHeartbeatSchedulingTask.class.getResource("/lib/sigar/" + libraryName);
////            path = path.replace("/BOOT-INF/classes!/", "/BOOT-INF/classes/");
////            ClassPathResource cpr = new ClassPathResource(path +"sigar" + File.separator + libraryName);
////            System.out.println("resource path:"+cpr.getPath());
//            System.out.println(url.getPath());
//            InputStream is = url.openStream();
////            InputStream is = cpr.getInputStream();
////            InputStream is = Sigar.class.getClass().getResourceAsStream("/sigar/" + libraryName);
//            File tmpDir = FileUtil.getTempDirectory();
//            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(tmpDir, libraryName), false));
//            FileCopyUtils.copy(is, bos);
//            String javaLibPath = System.getProperty("java.library.path");
//            String os = System.getProperty("os.name").toLowerCase();
//            if(!javaLibPath.contains(tmpDir.getName())){
//                if (os.contains("windows")){
//                    javaLibPath += ";" + tmpDir.getCanonicalPath();
//                    System.out.println("5>>"+javaLibPath);
//                }else {
//                    javaLibPath += ":" + tmpDir.getCanonicalPath();
//                    System.out.println("6>>"+javaLibPath);
//                }
//                System.setProperty("java.library.path", javaLibPath);
//                System.out.println("7>>"+System.getProperty("java.library.path"));
//            }
//            System.setProperty("org.hyperic.sigar.path", tmpDir.getCanonicalPath());
//            System.out.println("8>>"+System.getProperty("org.hyperic.sigar.path"));
//            System.out.println("9>>"+System.getProperty("java.library.path"));
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        } catch (ArchNotSupportedException e1) {
//            e1.printStackTrace();
//        }
//    }

}
