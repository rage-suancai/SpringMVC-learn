package com.SpringMvcController.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/yy-ds6")
public class BeanScopeController6 {

    @Autowired
    private TestBean bean;

    @ResponseBody
    @GetMapping("/a")
    public String hello() {
        return bean.toString();
    }

}
