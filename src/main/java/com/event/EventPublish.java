package com.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Holley
 * @Description 事件发布
 * @create 2018-07-13 11:47
 **/
@Component
public class EventPublish {

    @Autowired
    ApplicationContext applicationContext;
    /**
      * @Author holley
      * @Description 自定义发布事件
      * @Date 2018/7/13 11:50
      * @Param
      * @return
      */
    public void publish(String msg){
        applicationContext.publishEvent(new MyEvent(this,msg));
    }
}
