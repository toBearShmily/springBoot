package com.shmily.timer;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Administrator on 2017/2/23.
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {

    /*@Scheduled(cron = "0/5 * * * * ?")//20秒执行一次
    public void scheduler(){
        System.out.println("Scheduled is begin......");
    }*/
}
