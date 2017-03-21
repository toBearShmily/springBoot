package com.shmily.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/2/21.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String say(){
        return "hello word";
    }
}
