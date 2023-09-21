package com.SpringMvcController.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("yy-ds2")
public class RequestParamController3 {

    /*@GetMapping("/a")
    public ModelAndView hello(@RequestParam("username") String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }*/

    /*@GetMapping("/a")
    public ModelAndView hello(@RequestParam(value="username", required=false) String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }*/

    /*@GetMapping("/a")
    public ModelAndView hello(@RequestParam(value="username", required=false, defaultValue="伞兵一号") String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }*/

    @GetMapping("/a1")
    public ModelAndView hello(HttpServletRequest request) {

        System.out.println("接收到请求参数: " + request.getParameterMap().keySet());
        return new ModelAndView("index");

    }

    @GetMapping("/a2")
    public ModelAndView hello(HttpSession session) {

        System.out.println(session.getAttribute("test"));
        session.setAttribute("test", "鸡你太美");
        return new ModelAndView("index");

    }

}
