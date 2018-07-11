package com.config;

import com.controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.service.HelloJavaService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 配置类
 *
 * @author Holley
 * @create 2018-07-06 11:39
 **/
@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy // 启用spring对于aspectJ的支持
public class MyConfig {

    /**
      * @Author holley
      * @Description 使用java配置bean
      * @Date 2018/7/11 10:40
      * @Param
      * @return
      */
    @Bean
    public HelloJavaService helloJavaService(){
        return new HelloJavaService();
    }
    @Bean
    public HelloController helloController(){
        HelloController helloController = new HelloController();
        helloController.setHelloJavaService(helloJavaService());
        return helloController;
    }
    /**
      * @Author holley
      * @Description 另一种方法注入HelloController，直接将HelloJavaService作为helloController()方法的形参，
      * 原因：在spring容器中，只要存在某个bean，就可以在另外一个bean的声明方法的参数中注入
      * @Date 2018/7/11 10:43
      * @Param
      * @return
      */
    /*@Bean
    public HelloController helloController(HelloJavaService helloJavaService){
        HelloController helloController = new HelloController();
        helloController.setHelloJavaService(helloJavaService);
        return helloController;
    }*/
}
