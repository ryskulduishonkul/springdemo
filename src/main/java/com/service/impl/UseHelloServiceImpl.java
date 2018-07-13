package com.service.impl;

import com.aop.MyAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.HelloService;
import com.service.UserHelloService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-06 11:32
 **/
@Service("userHelloService")
public class UseHelloServiceImpl implements UserHelloService{
    /**
      * @Author holley
      * @Description 加上@PostConstruct注解，表示在构造函数执行完之后执行
      * @Date 2018/7/13 10:36
      * @Param
      * @return
      */
    @PostConstruct
    public void initdemo(){
        System.out.println("初始化注解bean");
    }

    @Autowired
    private HelloService helloService;

    @Override
    public String useSayHello(String name) {
        return helloService.sayHello(name);
    }
    /**
      * @Author holley
      * @Description 加上@PreDestroy注解，表示在bean销毁之前执行
      * @Date 2018/7/13 10:37
      * @Param
      * @return
      */
    @PreDestroy
    public void destroydemo(){
        System.out.println("销毁注解bean");
    }
}
