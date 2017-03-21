package com.shmily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * MapperScan注解会扫描该包下的接口(使用注解的方式进行使用MyBatis,当然也可以使用xml文件的方式进行使用)
 *
 *
 * 数据库监控
 * 通过注解方式实现的数据连接池监控需加上注解：@ServletComponentScan(在SpringBootApplication上面)使spring能够扫描到我们自己编写的servlet和filter。
 */
@ServletComponentScan
@SpringBootApplication
@MapperScan("com.shmily.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
