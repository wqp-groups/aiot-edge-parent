package com.wqp.aiot.edge.stream.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AiotEdgeSenseConfigEntity {
    private String productid;               // 产品id
    private String edgeid;                  // 边缘设备id
    private String uploaddirectory;         // 数据上传目录
    private String backupdirectory;         // 数据备份目录
    private Netty netty;                    // netty配置
    private int edgeHeartbeatFrequency;     // 边缘设备心跳频率

    @Data
    @NoArgsConstructor
    public static class Netty{
        private String host;                // 主机地址
        private int port;                   // 主机端口
        private String frameDelimiter;      // 数据桢分隔符
    }

}
