package com.SpringMvcInterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/index1")
    public String index1() {
        return "Hello Interceptor1";
    }

    @GetMapping("/index2")
    public String index2() {

        System.out.println("我是处理");
        if (true) throw new RuntimeException(""); return "index";

    }

}
