package com.SpringMvcController.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("yy-ds2")
public class MainController3 {

    /*@GetMapping("/a")
    public ModelAndView hello(@RequestParam("username") String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }*/

    @GetMapping("/a")
    public ModelAndView hello(@RequestParam(value="username", required=false) String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }



}
