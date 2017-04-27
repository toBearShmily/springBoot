package com.shmily.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/2/21.
 */
@RestController
public class HelloController {

    @RequestMapping("/say")
    public String say(){
        return "say";
    }

    @RequestMapping("/holle")
    public String holle(){
        return "hello word";
    }
}
