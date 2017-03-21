package com.shmily.support.startUp_task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Order - 计划任务执行的优先级
 * Created by Administrator on 2017/2/23.
 */
@Component
@Order(value = 1)
public class MyStartUpRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("项目启动....>>>>>计划任务启动.");
    }
}
