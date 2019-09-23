package com.wqp.aiot.edge.stream.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 业务属性实体数据对象
 */
@Data
@NoArgsConstructor
public class SenseDeviceEntity {
    private String productid;               // 产品id
    private String edgeid;                  // 边缘设备id
    private List<DeviceData> devicedata;    // 传感设备数据集

    /**
     * 传感采集数据
     */
    @Data
    @NoArgsConstructor
    public static class DeviceData{
        private String deviceid;        // 设备id
        private String version;         // 版本
        private String gathertime;      // 采集时间
        private String dataname;        // 数据名
        private String datavalue;       // 数据值
    }
}


