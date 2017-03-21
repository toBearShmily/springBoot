package com.shmily.druid_Monitor.druidFilter;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;

/**
 * @WebListener - 监听同理
 * Created by Administrator on 2017/2/23.
 */
@WebFilter(filterName = "druidWebStatFilter",urlPatterns = "/*",
            initParams = {
                    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
            })
public class DruidStatFilter extends WebStatFilter {
}
