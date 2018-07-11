package com.controller;

import com.aop.MyAnnotation;
import com.service.HelloJavaService;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-06 10:50
 **/
public class HelloController {
    private HelloJavaService helloJavaService;

    @MyAnnotation(name = "java配置bean的aop")
    public String hello(String name){
        return helloJavaService.sayhello(name);
    }

    public void setHelloJavaService(HelloJavaService helloJavaService){
        this.helloJavaService = helloJavaService;
    }


}
