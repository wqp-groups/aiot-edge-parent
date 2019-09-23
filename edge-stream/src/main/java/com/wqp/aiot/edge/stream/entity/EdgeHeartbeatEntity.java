package com.wqp.aiot.edge.stream.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 边缘设备心跳数据实体对象
 */
@Data
@NoArgsConstructor
public class EdgeHeartbeatEntity {
    private String gathertime;                      // 采集时间
    private EdgeHeartbeat edgeheartbeat;            // 边缘设备心跳数据
    private List<DeviceHeartbeat> deviceheartbeat;  // 传感设备心跳数据

    /**
     * 边缘设备心跳数据实体
     */
    @Data
    @NoArgsConstructor
    public static class EdgeHeartbeat{
        private String edgeid;                  // 边缘设备id
        private boolean edgestatus;             // 边缘设备状态
        private String osname;                  // 操作系统名称
        private String osarch;                  // 操作系统内核类型
        private String memorytotal;             // 内存总
        private String memoryused;              // 内存使用
        private String memoryfree;              // 内存剩余
        private String cpuuserrate;             // cpu用户使用率
        private String cpusysrate;              // cpu系统使用率
        private String cpuidlerate;             // cpu当前空闲率
        private String cpucombinedrate;         // cpu总使用率
        private String netip;                   // 网络ip地址
        private String filedisktotal;           // 文件磁盘总大小
        private String filediskfree;            // 文件磁盘剩余
        private String filediskavail;           // 文件磁盘可用

    }

    /**
     * 传感设备心跳数据实体
     */
    @Data
    @NoArgsConstructor
    public static class DeviceHeartbeat{
        private String deviceid;                // 设备id
        private boolean devicestatus;           // 设备状态
    }
}
