package com.shmily.controller;

import com.shmily.dao.Mapper.RoleMapper;
import com.shmily.dao.RoleJpa;
import com.shmily.model.Role;
import com.shmily.service.RoleJPAService;
import com.shmily.support.annotation.Permission;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.*;


/**
 * Created by Administrator on 2017/2/22.
 */
@RestController
@RequestMapping(name = "角色管理", value = "/role")
public class RoleJPAController {

    @Autowired
    private RoleJPAService roleJPAService;

    @RequestMapping(name = "角色添加", value="/save" )
    @Permission(name = "角色添加", value = "role:save")
    public String save(@RequestParam("id") int id, @RequestParam("name")String name, @RequestParam("roleDescribe")String roleDescribe){
        Role role = new Role();
        role.setId(id);
        role.setRoleName(name);
        role.setRoleDescribe(roleDescribe);
        roleJPAService.save(role);
        return "success";
    }

    @Value("${web.upload-path}")
    private String path;

    /** 文件上传测试 */
    @RequestMapping(name = "文件上传测试", value = "/upload")
    public void uploadTest() throws Exception {
        File f = new File("C:/Users/Administrator/Desktop/ChMkJlfI162IeK07AAY_egKaTWoAAU6qQHhDUcABj-S342.jpg");
        FileCopyUtils.copy(f, new File(path+"/1.jpg"));
    }

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleJpa roleJpa;

    @RequestMapping(name = "动态sql测试", value = "/sqlT")
    public void RoleTest(){
        System.out.println("==========================开始==============================");
        Role role = roleJpa.findOne(1);

        System.out.println("role为："+role.toString());
        System.out.println("========================================================");
        role.setRoleName("new Test");
        role.setRoleDescribe("new Test");
        role.setUpdateTime(new DateTime(new Date()).toString("yyyy-MM-dd HH:mm:ss"));
        Integer result = roleMapper.update(role);
        System.out.println(result > 0 ? "success" : "fail");

        System.out.println("========================================================");

        List<Map<String, Object>> list = roleMapper.list();
        System.out.println("list返回为："+list);

        System.out.println("========================================================");

        List<Map<String, Object>> pramsList = new ArrayList<>();
        Map<String, Object> prams = null;
        for(Map<String, Object> m : list){
            prams = new HashMap<>();
            System.out.println("id为："+m.get("role_describe"));
            prams.put("id",roleJpa.findOne((Integer) m.get("id")));
            pramsList.add(prams);
        }
        System.out.println("pramsList返回为："+pramsList);

        /*Map<Integer, Map<String, Object>> map = roleMapper.map(pramsList);
        System.out.println("map返回为："+map);*/
        System.out.println("==========================结束==============================");
    }

}
