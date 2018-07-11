package com.service.impl;

import com.aop.MyAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.HelloService;
import com.service.UserHelloService;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-06 11:32
 **/
@Service("userHelloService")
public class UseHelloServiceImpl implements UserHelloService{

    @Autowired
    private HelloService helloService;
    @Override
    public String useSayHello(String name) {
        return helloService.sayHello(name);
    }
}
