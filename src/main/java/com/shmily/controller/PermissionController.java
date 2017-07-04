package com.shmily.controller;

import com.shmily.model.Permission;
import com.shmily.service.PermissionService;
import com.shmily.support.common.Response;
import com.shmily.support.common.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;


/**
 * Created by shmily on 2017/6/9.
 */
@RestController
@Validated
@RequestMapping(name = "权限管理" , value = "/permission")
public class PermissionController {
    private Logger log = LoggerFactory.getLogger(PermissionController.class);

    @Resource
    private PermissionService permissionService;

    @RequestMapping(name = "添加权限", value = "/save")
    @com.shmily.support.annotation.Permission(name = "添加权限", value = "permission:save")
    public Response save(@Valid Permission permission, BindingResult result){
        //result.rejectValue("name", "misFormat", "该name已经存在了！");可能会用到
        permissionService.save(permission);
        return ResponseUtil.success();
    }

    /**
     * 供测试使用
     * @param id
     * @return
     */
    @RequestMapping(name = "test", value = "/test")
    public String save(@Min(value = 2,message = "kpId必须大于等于0") @RequestParam(name = "id") int id){
        System.out.println(id);
        return ""+id;
    }
}
