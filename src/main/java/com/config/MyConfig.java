package com.config;

import com.controller.HelloController;
import com.service.ProfileJavaBean;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import com.service.HelloJavaService;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * 配置类
 *
 * @author Holley
 * @create 2018-07-06 11:39
 **/
@Configuration
@ComponentScan("com")
@EnableAspectJAutoProxy // 启用spring对于aspectJ的支持
@PropertySource("classpath:test.properties") // 指定文件地址
public class MyConfig {
    // 注入普通字符串
    @Value("i love u")
    private String normal;
    // 注入操作系统属性
    @Value("#{systemProperties['os.name']}")
    private String osName;
    // 注入表达式结果
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber;
    // 注入其他bean属性
    @Value("#{propertiesService.anthor}")
    private String fromAnother;
    // 注入文件资源
    @Value("classpath:test.txt")
    private Resource testFile;
    // 注入网址资源
    @Value("http://www.baidu.com")
    private Resource testUrl;
    // 注入配置文件（需在类名上使用@PropertySource注解指定文件地址，同时如果使用@value注入，则需要配置一个PropertySourcesPlaceholderConfigurer的Bean）
    @Value("${demo.name}")
    private String demoName;
    // 注入properties除了通过@value注入外还可以通过Enviroment中获的
    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    public void outputResource(){
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);
            System.out.println(demoName);
            System.out.println(environment.getProperty("demo.author"));
            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
      * @Author holley
      * @Description 使用java配置bean(可以通过initMethod/destroyMethod 来设置初始化和销毁的方法，该方法就写在HelloJavaService类中)
      * @Date 2018/7/11 10:40
      * @Param
      * @return
      */
    @Bean(initMethod = "initdemo",destroyMethod = "destroydemo")
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
    @Bean
    @Profile("pre")
    public ProfileJavaBean preJavaBean(){
        return new ProfileJavaBean("生产环境下的bean实例");
    }
    @Bean
    @Profile("dev")
    public ProfileJavaBean devJavaBean(){
        return new ProfileJavaBean("开发环境下的bean实例");
    }
}
