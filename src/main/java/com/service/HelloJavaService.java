package com.service;

import com.aop.MyAnnotation;

/**
 * spring不使用注解的形式来注入bean，使用java配置的形式
 *
 * @author Holley
 * @create 2018-07-11 10:28
 **/
public class HelloJavaService {

    public void initdemo(){
        System.out.println("初始化java配置的bean");
    }

    @MyAnnotation(name = "java配置service bean的aop")
    public String sayhello(String name){
        return "hello," + name + ",i am java配置";
    }

    public void destroydemo(){
        System.out.println("销毁java配置的bean");
    }

}
