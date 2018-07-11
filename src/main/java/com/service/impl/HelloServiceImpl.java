package com.service.impl;

import com.aop.MyAnnotation;
import org.springframework.stereotype.Service;
import com.service.HelloService;

/**
 * @author Holley
 * @create 2018-07-06 10:51
 **/
@Service("helloService")
public class HelloServiceImpl implements HelloService{

    @MyAnnotation(name = "zzzz")
    @Override
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}
