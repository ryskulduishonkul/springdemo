package com.aop;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author Holley
 * @create 2018-07-11 11:19
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//@Documented
public @interface MyAnnotation {
    String name();
}
