package com.wqp.aiot.edge.stream.task;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wqp.aiot.edge.stream.entity.AiotEdgeConfigEntity;
import com.wqp.aiot.edge.stream.entity.SenseDeviceEntity;
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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 默认Netty方式定时数据上传任务
 * 执行周期：1秒
 * 数据上传成功后文件移至备份目录
 */
@Component
@EnableScheduling
public class DefaultNettyProcessSchedulingTask implements SchedulingConfigurer {

    @Autowired
    private AiotEdgeConfigEntity aiotEdgeSenseConfigEntity;

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
        scheduledTaskRegistrar.addFixedDelayTask(() -> process(client), 1000);
//        scheduledTaskRegistrar.addTriggerTask(() -> process(client), triggerContext -> new CronTrigger("0/3 * * * * ?").nextExecutionTime(triggerContext));

    }

    /**
     * 通过客户端句柄处理数据
     * @param client
     */
    private void process(NettyExecutorClient client) {
        File file = new File(aiotEdgeSenseConfigEntity.getUploaddirectory());
        File[] files = file.listFiles((dir, name) -> name.endsWith(".json"));
        if(files == null || files.length == 0) {
            System.out.println("暂无可上传json数据,静候3秒再执行");
            return;
        }
        Arrays.asList(files).stream().forEach(f -> {
            SenseDeviceEntity deviceSenseEntity = JacksonMapperUtil.json2object(f, new TypeReference<SenseDeviceEntity>() {});
            StreamTransferProtof.StreamTransferData.Builder builder = StreamTransferProtof.StreamTransferData.newBuilder();
            builder.setTransfertime(DateUtil.format(new Date(), DateUtil.DATE_PATTERN_ONE));
            builder.setEdgeid(aiotEdgeSenseConfigEntity.getEdgeid());
            builder.setOrigindata(JacksonMapperUtil.object2json(deviceSenseEntity));
            builder.setOriginname(f.getName());
            builder.setOrigintopic(StreamTransferTopic.EDGE_UPLOAD_SENSOR_DATA.getType());

            ByteBuf byteBuf = Unpooled.wrappedBuffer(Unpooled.copiedBuffer(builder.build().toByteArray()), Unpooled.copiedBuffer(client.getNettyConf().getFrameDelimiter().getBytes()));
            client.publish(byteBuf, (status, msg) -> {
                System.out.println("发送状态："+status+",返回消息："+msg);
                if(status){
                    f.renameTo(new File(aiotEdgeSenseConfigEntity.getBackupdirectory() + File.separator + f.getName()));
                    f.delete();
                }
            });
        });
    }

}
