package com.aware;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Holley
 * @Description 使用spring容器的服务
 * BeanNameAware:获得容器中Bean的名称
 * BeanFactoryAware:获得当前bean factory,这样可以调用容器的服务
 * ApplicationContextAware:获得当前的application context,这样可以调用容器的服务（因为ApplicationContext接口集成了MessageSource接口，ApplicationEventPublisher接口和
 *                          ResourceLoader接口,所以Bean继承了ApplicationContextAware就可以获得spring容器的所有服务）
 * MessageSourceAware:获得message source,这样可以获得文本信息
 * ApplicationEventPublisherAware:应用事件发布器，可以发布事件，自定义的EventPublish类可以实现这个接口来发布事件
 * ResourceLoaderAware:获得资源加载器，可以获得外部资源文件
 * @create 2018-07-13 12:04
 **/
@Service("awareService")
public class AwareService implements BeanNameAware,ResourceLoaderAware{

    private String beanName;

    private ResourceLoader loader;
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void output(){
        System.out.println("this.beanName = " + beanName);
        Resource resource = loader.getResource("classpath:test.txt");
        try {
            System.out.println("加载的文件内容为：" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
