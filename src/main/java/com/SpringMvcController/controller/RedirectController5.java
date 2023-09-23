package com.SpringMvcController.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/yy-ds5")
public class RedirectController5 {

    @RequestMapping("/index1")
    public String index1() {
        return "redirect:home";
    }
    @RequestMapping("/home1")
    public String home1() {
        return "index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "forward:home2";
    }
    @RequestMapping("/home2")
    public String home2() {

        System.out.println("hello");
        return "index";

    }

}
