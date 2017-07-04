package com.shmily.support;

import com.shmily.service.PermissionService;
import com.shmily.support.annotation.Permission;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;
import java.util.*;


/**
 * Created by shmily on 2017/6/8.
 */
@Component
public class PermissionVerifier implements BeanPostProcessor{
    private Logger log = LoggerFactory.getLogger(PermissionVerifier.class);
    @Resource
    private PermissionService permissionService;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        com.shmily.model.Permission per = null;
        if(bean instanceof RequestMappingHandlerMapping){
            //存储权限的map
            Map<String, String> permissionMap = new HashMap<>();
            Set<String> permissions = new HashSet<>();
            String controllerName = ""; // controller的@RequestMapping的name
            Map<String, String> controllerNameMap = new HashMap<>();
            String actionName = ""; // method的@RequestMapping的name
            Map<String, String> actionNameMap = new HashMap<>();
            Boolean enable = null;
            RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) bean;

                String url = this.getClass().getResource("").getPath();
                log.info("url : "+url);

            Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
            for (Map.Entry<RequestMappingInfo, HandlerMethod> entry : handlerMethods.entrySet()) {
                HandlerMethod method = entry.getValue();

                String name = entry.getKey().getName();
                log.info("bean创建后获取的name为：{}", name);
                if (StringUtils.contains(name, "#")) {
                    String[] names = StringUtils.split(name, "#");
                    log.info("分割后的name："+names);
                    controllerName = names[0]; // 根据#分割取出controller的@RequestMapping的name
                    controllerNameMap.put(name,controllerName);
                    actionName = names[1];
                    actionNameMap.put(name,actionName);
                }else {
                    actionName = name;
                }

                //获取对应权限入库
                Permission permission = method.getMethodAnnotation(Permission.class);
                if(null == permission){
                    //throw new BizException(StateEnum.NO_PERMISSION_ANNOTATION);
                    //对于自动化操作未入库的权限记录下来,后期这里可以做其他处理
                    log.info("权限："+actionName+" 未入库");
                }else{
                    enable = permission.enable();
                    String value = permission.value();
                    permissionMap.put(name,value);
                    permissions.add(value);
                }
            }
            for (Map.Entry<String, String> entry1 : permissionMap.entrySet()) {
                String nameentry1 = entry1.getKey();
                String valueentry1 = entry1.getValue();

                log.info("value : "+valueentry1 +" , description : "+nameentry1+ " , enable : " +enable);
                if(permissionService.findByName(valueentry1)){
                    per = new com.shmily.model.Permission();
                    per.setName(valueentry1);
                    per.setCategory(1);
                    per.setDescription(actionNameMap.get(nameentry1));
                    per.setCreateTime(new DateTime(new Date()).toString("yyyy-MM-dd HH:mm:ss"));
                    per.setUpdateTime(new DateTime(new Date()).toString("yyyy-MM-dd HH:mm:ss"));
                    if(controllerName != null){
                        per.setModule(controllerNameMap.get(nameentry1));
                    }
                    per.setMethodPath("");
                    per.setEnable(enable == true ? 1 : 0);
                    permissionService.save(per);
                }else {
                    continue;
                }

            }


        }
        return bean;
    }
}
