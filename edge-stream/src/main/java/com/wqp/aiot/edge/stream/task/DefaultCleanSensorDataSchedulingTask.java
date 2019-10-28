package com.wqp.aiot.edge.stream.task;

import com.wqp.aiot.edge.stream.entity.AiotEdgeConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Arrays;

/**
 * 定时清理传感器采集备份数据
 * 默认执行周期：60秒
 * 清理大于60秒以上的采集备份数据
 */
@Component
@EnableScheduling
public class DefaultCleanSensorDataSchedulingTask implements SchedulingConfigurer {

    @Autowired
    private AiotEdgeConfigEntity aiotEdgeSenseConfigEntity;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        Assert.notNull(aiotEdgeSenseConfigEntity, "边缘设备未正确配置基础参数");
        // 注册调度
        scheduledTaskRegistrar.addTriggerTask(() -> process(), triggerContext -> new CronTrigger("0/60 * * * * ?").nextExecutionTime(triggerContext));
    }

    private void process(){
        long currentTimeMillis = System.currentTimeMillis();
        File deleteFile = new File(aiotEdgeSenseConfigEntity.getBackupdirectory());
        File[] files = deleteFile.listFiles((dir, name) -> name.endsWith(".json"));
        if(files == null || files.length == 0) {
            System.out.println("暂无可删除json数据,静候60秒再执行");
            return;
        }
        Arrays.asList(files).stream().forEach(d -> {
            if((currentTimeMillis - d.lastModified()) > 60000) d.delete();
        });
    }
}
