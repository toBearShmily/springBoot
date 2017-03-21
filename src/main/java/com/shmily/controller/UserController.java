package com.shmily.controller;

import com.github.pagehelper.PageHelper;
import com.shmily.model.User;
import com.shmily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
@RestController
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list(){
        return userService.allUser();
    }

    @RequestMapping("/{nickName}")
    public User getUser(@PathVariable("nickName") String name){
        return userService.getByNickName(name);
    }

    /**
     *
     * @param pageNum 第几页
     * @param pageSize 每页显示条数
     * @return
     */
    @RequestMapping("/pageHelperUser/{pageNum}/{pageSize}")
    public List<User> pageHelperUser(@PathVariable("pageNum") int pageNum,@PathVariable("pageSize") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        System.out.println("aaa");
        if(true){
            System.out.println("bbb");
        }
        return userService.allUser();
    }
}
