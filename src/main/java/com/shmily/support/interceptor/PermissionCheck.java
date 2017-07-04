package com.shmily.support.interceptor;

import com.shmily.exception.BizException;
import com.shmily.support.annotation.Permission;
import com.shmily.util.SerializationUtil;
import com.shmily.util.redis_common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;

/**
 * 对自定义的权限进行拦截的权限拦截器
 * Created by shmily on 2017/6/13.
 */
public class PermissionCheck implements HandlerInterceptor {

    private Logger log = LoggerFactory.getLogger(PermissionCheck.class);

    /**
     * 请求前检查是否有权限访问
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception，
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //请求token
        String token = request.getParameter("sign");
        log.info("handler 属于："+handler.getClass());
        String url = request.getRequestURI();
        log.info("当前请求地址："+url);
        Jedis jedis = redis_common.REDIS.getJedis();

        HandlerMethod method = (HandlerMethod) handler;
        Permission permission = method.getMethodAnnotation(Permission.class);
        if(null != permission){
            String permissvalue = permission.value();
            //从登陆后的缓存中取得当前用户的权限
            if(!permission.enable()) return true;

            boolean exists = jedis.sismember(token, permission.value());
            return exists == true ? true : false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
