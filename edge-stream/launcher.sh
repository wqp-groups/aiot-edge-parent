#!/bin/bash
export JAVA_HOME=/aiot/java/jdk1.8.0_221
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
nohup java -jar /aiot/server/aiot-edge-stream-0.0.1-SNAPSHOT.jar > /aiot/server/java-nohup.out 2>&1 &
nohup python3 /aiot/server/aiot-edge-sensor-0.0.1/source/main/core/launcher.py > /aiot/server/python-nohup.out 2>&1 &