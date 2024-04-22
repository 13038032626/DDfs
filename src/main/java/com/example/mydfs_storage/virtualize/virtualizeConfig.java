package com.example.mydfs_storage.virtualize;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.management.*;

@Configuration
public class virtualizeConfig {

    /*
    ManageMentFactory
    通过该类包含可以查看很多信息：操作系统模块、类加载器模块、编译器模块、内存管理模块、内存池管理模块、JVM在运行时管理的bean、JVM线程系统管理的bean等等信息
     */
    @Bean
    public MemoryMXBean getMemory(){
        return ManagementFactory.getMemoryMXBean();
    }
    @Bean
    public ThreadMXBean getThread(){
        return ManagementFactory.getThreadMXBean();
    }
    @Bean
    public OperatingSystemMXBean getOperatingSystem(){
        return ManagementFactory.getOperatingSystemMXBean();
    }
    @Bean
    public ClassLoadingMXBean getClassLoading(){
        return ManagementFactory.getClassLoadingMXBean();
    }
    @Bean
    public RuntimeMXBean getRuntime(){
        return ManagementFactory.getRuntimeMXBean();
    }

    public void test(){
        ThreadMXBean thread = getThread();
        ClassLoadingMXBean classLoading = getClassLoading();
        MemoryMXBean memory = getMemory();
        RuntimeMXBean runtime = getRuntime();
        OperatingSystemMXBean operatingSystem = getOperatingSystem();

        thread.resetPeakThreadCount();

    }
}
