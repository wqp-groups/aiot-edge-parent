package com.wqp.aiot.edge.stream.conf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wqp.aiot.edge.stream.entity.AiotEdgeConfigEntity;
import com.wqp.common.util.common.JacksonMapperUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.io.File;

//@Data
//@Component
//@ConfigurationProperties(prefix = "netty")
@Configuration
public class StreamNettyConfiguration {
//    private String host;
//    private Integer port;
//    private String frameDelimiter;
//    private String uploadDirectory;

    @Value(value = "${aiot.edge.sense.config-file}")
    private String aiotEdgeSenseConfigFile;
    @Value(value = "${aiot.edge.netty.host}")
    private String aiotEdgeNettyHost;
    @Value(value = "${aiot.edge.netty.port}")
    private int aiotEdgeNettyPort;
    @Value("${aiot.edge.netty.frame-delimiter}")
    private String aiotEdgeNettyFrameDelimiter;
    @Value("${aiot.edge.heartbeat.frequency}")
    private int aiotEdgeHeartbeatFrequency;

    @Bean
    public AiotEdgeConfigEntity aiotEdgeSenseConfig(){
//        String os_name = System.getProperty("os.name");
//        File confFile = new File(os_name.contains("Windows") ? aiotEdgeSenseConfigWindows : aiotEdgeSenseConfigLinux);
        Assert.notNull(aiotEdgeSenseConfigFile, "配置文件未设置");
        File confFile = new File(aiotEdgeSenseConfigFile);
        AiotEdgeConfigEntity aiotEdgeSenseConfigEntity = JacksonMapperUtil.json2object(confFile, new TypeReference<AiotEdgeConfigEntity>(){});
        Assert.notNull(aiotEdgeSenseConfigEntity, "配置文件解析失败");
        Assert.notNull(aiotEdgeSenseConfigEntity.getProductid(), "产品ID未设置");
        Assert.notNull(aiotEdgeSenseConfigEntity.getEdgeid(), "边缘设备ID未设置");
        Assert.notNull(aiotEdgeSenseConfigEntity.getUploaddirectory(), "传感器数据上传目录未设置");
        Assert.notNull(aiotEdgeSenseConfigEntity.getBackupdirectory(), "传感器数据备份目录未设置");
        Assert.notNull(aiotEdgeSenseConfigEntity.getNetty(), "Netty传输配置未设置");
        if(aiotEdgeSenseConfigEntity.getNetty() == null) aiotEdgeSenseConfigEntity.setNetty(new AiotEdgeConfigEntity.Netty());
        if(StringUtils.isEmpty(aiotEdgeSenseConfigEntity.getNetty().getHost())) aiotEdgeSenseConfigEntity.getNetty().setHost(aiotEdgeNettyHost);
        if(aiotEdgeSenseConfigEntity.getNetty().getPort() == 0) aiotEdgeSenseConfigEntity.getNetty().setPort(aiotEdgeNettyPort);
        if(StringUtils.isEmpty(aiotEdgeSenseConfigEntity.getNetty().getFrameDelimiter())) aiotEdgeSenseConfigEntity.getNetty().setFrameDelimiter(aiotEdgeNettyFrameDelimiter);

        // 传感器采集上传目录/备份目录验证
        File uploadDir = new File(aiotEdgeSenseConfigEntity.getUploaddirectory());
        if(!uploadDir.exists()) uploadDir.mkdirs();
        File backupDir = new File(aiotEdgeSenseConfigEntity.getBackupdirectory());
        if(!backupDir.exists()) backupDir.mkdirs();

        // 边缘设备心跳频率设置
        aiotEdgeSenseConfigEntity.setEdgeHeartbeatFrequency(aiotEdgeHeartbeatFrequency == 0 ? 180000 : aiotEdgeHeartbeatFrequency);
        return aiotEdgeSenseConfigEntity;
    }

}
