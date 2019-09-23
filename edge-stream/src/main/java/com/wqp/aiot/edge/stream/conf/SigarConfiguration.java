package com.wqp.aiot.edge.stream.conf;

import org.springframework.context.annotation.Configuration;

import java.nio.file.Paths;

/**
 * 使用静态加载配置sigar环境变量
 */
@Configuration
public class SigarConfiguration {

    static {
//        initSigar();
    }

    public static void initSigar(){
//        SigarLoader sigarLoader = new SigarLoader(Sigar.class);
//        try {
//            String libraryName = sigarLoader.getLibraryName();
//            String os = System.getProperty("os.name").toLowerCase();
//            String javaLibPath = System.getProperty("java.library.path");
//            String sigalEnvPath = Paths.get("d:", "aiot", "server").toString();
//            if (os.contains("windows")){
//                javaLibPath += ";" + sigalEnvPath;
//            }else {
//                javaLibPath += ":" +sigalEnvPath;
//            }
//            System.setProperty("java.library.path", javaLibPath);
//            System.setProperty("org.hyperic.sigar.path", sigalEnvPath);
//
//        } catch (ArchNotSupportedException e1) {
//            e1.printStackTrace();
//        }

        String os = System.getProperty("os.name").toLowerCase();
        String javaLibPath = System.getProperty("java.library.path");
        String sigalEnvPath = Paths.get("d:", "aiot", "server").toString();
        if (os.contains("windows")){
            javaLibPath += ";" + sigalEnvPath;
        }else {
            javaLibPath += ":" +sigalEnvPath;
        }
        System.setProperty("java.library.path", javaLibPath);
        System.setProperty("org.hyperic.sigar.path", sigalEnvPath);
    }

}
