package com.SpringMvcExceptions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exceptions")
public class HelloController {

    @RequestMapping("/index")
    public String index() {

        System.out.println("我是处理");
        if (true) throw new RuntimeException("你的氪金力度不足 无法访问");
        return "index";

    }

}
