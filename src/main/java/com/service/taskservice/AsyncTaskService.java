package com.service.taskservice;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Holley
 * @Description 使用@Async注解表明该方法是个异步方法，如果注解在类级别，则表明该类所有的方法都是异步方法
 * 这里的方法自动被注入ThreadPoolTaskExecutor作为TaskExecutor
 * @create 2018-07-13 16:39
 **/
@Service("asyncTaskService")
public class AsyncTaskService {

    private Thread t = Thread.currentThread();
    @Async
    public void eat(Integer i){
        System.out.println("执行异步任务eat：" + i + ",线程名：" + t.getName());
    }
    @Async
    public void drink(Integer i){
        System.out.println("执行异步任务drink：" + i + ",线程名：" + t.getName());
    }
}
