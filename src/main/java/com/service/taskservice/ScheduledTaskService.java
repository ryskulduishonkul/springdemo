package com.service.taskservice;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Holley
 * @Description 计划任务
 * @create 2018-07-13 17:36
 **/
@Service("scheduledTaskService")
public class ScheduledTaskService {

    private static final SimpleDateFormat sfd = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime(){
        System.out.println("每隔五秒执行一次 " + sfd.format(new Date()));
    }

    /*@Scheduled(fixedDelay = 10000)
    public void fixedDelayDemo(){
        System.out.println("延迟10秒执行 " + sfd.format(new Date()));
    }*/

    @Scheduled(cron = "0 17 18 ? * *")
    public void fixtime(){
        System.out.println("在指定时间执行 " + sfd.format(new Date()));
    }
}
