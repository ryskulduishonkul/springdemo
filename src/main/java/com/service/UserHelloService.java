package com.service;

import com.aop.MyAnnotation;
import org.springframework.stereotype.Component;

/**
 * 请输入一段话进行描述
 *
 * @author Holley
 * @create 2018-07-06 11:33
 **/
public interface UserHelloService {

    String useSayHello(String name);
}
