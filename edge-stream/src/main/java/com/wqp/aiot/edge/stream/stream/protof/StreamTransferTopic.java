package com.wqp.aiot.edge.stream.stream.protof;

import lombok.Getter;

@Getter
public enum  StreamTransferTopic {
    // 边缘设备上传传感器采集数据
    EDGE_UPLOAD_SENSOR_DATA("EDGE_UPLOAD_SENSOR_DATA"),
    // 边缘设备上传边缘设备心跳数据
    EDGE_UPLOAD_HEARTBEAT_DATA("EDGE_UPLOAD_HEARTBEAT_DATA");

    StreamTransferTopic(String type){
        this.type = type;
    }

    private String type;

}
