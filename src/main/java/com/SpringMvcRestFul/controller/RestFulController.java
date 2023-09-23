package com.SpringMvcRestFul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/restful")
public class RestFulController {

    @GetMapping("/index1/{str}")
    public String index1(@PathVariable String str) {
        System.out.println(str); return "index";
    }
    @GetMapping("/index2/{str}")
    public String index2(@PathVariable("str") String text) {
        System.out.println(text); return "index";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") String text) {
        System.out.println("获取用户: " + text); return "index";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(String username) {
        System.out.println("添加用户: " + username); return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") String text) {
        System.out.println("删除用户: " + text); return "index";
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public String put(String username) {
        System.out.println("修改用户: " + username); return "index";
    }

}
