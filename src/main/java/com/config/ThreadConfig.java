package com.config;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author Holley
 * @Description @EnableAsync:开启异步任务支持
 * @create 2018-07-13 16:32
 **/
@Configuration
@EnableAsync
@ComponentScan("com")
@EnableScheduling //开启计划任务
public class ThreadConfig implements AsyncConfigurer{

    /**
      * @Author holley
      * @Description 重写方法，返回一个基于线程池的任务执行器TaskExecutor
      * @Date 2018/7/13 16:37
      * @Param
      * @return
      */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
