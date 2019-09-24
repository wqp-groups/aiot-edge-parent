#边缘设备目录结构定义

##Linux环境
+ 目录结构：
```
/aiot                                   根目录
    /server                             服务程序目录
        /launcher.sh                    服务程序启动脚本
        /aiot-edge-sense-*-*.jar        服务程序jar
        /aiotedgesenseconf.json         边缘设备业务参数配置文件
    /sensor                             传感器程序目录
        /uploaddata                     传感器数据上传目录
        /backupdata                     传感器数据上传备份目录
    /java                               jdk 安装目录
    /pkg                                安装包存储目录
```
                
                




##Windows环境
+ 目录结构