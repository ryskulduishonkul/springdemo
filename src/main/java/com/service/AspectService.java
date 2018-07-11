package com.service;

import com.aop.MyAnnotation;
import org.springframework.stereotype.Service;

/**
 * @author Holley
 * @create 2018-07-11 10:28
 **/
@Service
public class AspectService {
    @MyAnnotation(name = "注解拦截")
    public String sayhello(String name){
        return "hello," + name + ",i am AOP";
    }
}
