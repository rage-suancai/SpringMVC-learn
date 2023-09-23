package com.SpringMvcController.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/yy-ds2")
public class RequestParamController3 {

    @GetMapping("/a1")
    public ModelAndView hello1(@RequestParam("username") String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }

    @GetMapping("/a2")
    public ModelAndView hello2(@RequestParam(value="username", required=false) String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }

    @GetMapping("/a3")
    public ModelAndView hello3(@RequestParam(value="username", required=false, defaultValue="伞兵一号") String username) {

        System.out.println("接收到请求参数: " + username);
        return new ModelAndView("index");

    }

    @GetMapping("/a4")
    public ModelAndView hello4(HttpServletRequest request) {

        System.out.println("接收到请求参数: " + request.getParameterMap().keySet());
        return new ModelAndView("index");

    }

    @GetMapping("/a5")
    public ModelAndView hello5(HttpSession session) {

        System.out.println(session.getAttribute("test"));
        session.setAttribute("test", "鸡你太美");
        return new ModelAndView("index");

    }

}
