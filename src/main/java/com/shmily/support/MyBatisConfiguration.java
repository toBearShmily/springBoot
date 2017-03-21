package com.shmily.support;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 注册MyBatis分页插件PageHelper
 * Created by Administrator on 2017/2/22.
 * @version v.0.1
 */
@Configuration
public class MyBatisConfiguration {

    @Bean
    public PageHelper pageHelper(){
        System.out.println("MyBatisConfiguration pageHelper...");
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
