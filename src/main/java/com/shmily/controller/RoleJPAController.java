package com.shmily.controller;

import com.shmily.dao.RoleJPA;
import com.shmily.model.Role;
import com.shmily.service.RoleJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.File;

/**
 * Created by Administrator on 2017/2/22.
 */
@RestController
public class RoleJPAController {

    @Autowired
    private RoleJPAService roleJPAService;

    @RequestMapping("/save")
    public String save(@RequestParam("id") int id, @RequestParam("name")String name, @RequestParam("roleDescribe")String roleDescribe){
        Role role = new Role(id,name,roleDescribe);
        roleJPAService.save(role);
        return "success";
    }

    @Value("${web.upload-path}")
    private String path;

    /** 文件上传测试 */
    @RequestMapping("/upload")
    public void uploadTest() throws Exception {
        File f = new File("C:/Users/Administrator/Desktop/ChMkJlfI162IeK07AAY_egKaTWoAAU6qQHhDUcABj-S342.jpg");
        FileCopyUtils.copy(f, new File(path+"/1.jpg"));
    }



}
