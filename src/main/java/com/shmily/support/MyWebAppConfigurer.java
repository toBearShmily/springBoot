package com.shmily.support;

import com.shmily.support.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 自定义资源映射
 * 通过自己新建的文件，定义静态文件访问路径
 * Created by Administrator on 2017/2/22.
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myFile/**").addResourceLocations("classpath:/myFile/");

        //引用外部文件
        registry.addResourceHandler("/cp/**").addResourceLocations("file:C:/Users/Administrator/Desktop/");
        super.addResourceHandlers(registry);
    }


    /**
     * 重写拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
