package com.shmily.druid_Monitor;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @WebListener - 监听同理
 * 通过注解方式实现数据库连接池的监控和统计
 * Created by Administrator on 2017/2/23.
 */
@WebServlet(urlPatterns = "/druid/*",
            initParams = {
                    @WebInitParam(name="allow",value="127.0.0.1,192.168.17.79"),// IP白名单 (没有配置或者为空，则允许所有访问)
                    @WebInitParam(name="deny",value="192.168.17.78"),// IP黑名单 (存在共同时，deny优先于allow)
                    @WebInitParam(name="loginUsername",value="admin"),// 用户名
                    @WebInitParam(name="loginPassword",value="123456"),// 密码
                    @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
            })
public class DruidStatViewServlet extends StatViewServlet {
}
