package com.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Holley
 * @Description 自定义事件监听器
 * @create 2018-07-13 11:42
 **/
@Component
public class MyListener implements ApplicationListener<MyEvent>{

    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        String msg = myEvent.getMsg();
        System.out.println("MyListener-bean收到了myEvent-bean的消息：" + msg);
    }
}
