package com.SpringMvcController.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("yy-ds3")
public class CookieValueController4 {

    @RequestMapping(value = "/index1")
    public ModelAndView index1(HttpServletResponse response,
                               @CookieValue(value="test", required=false) String test) {

        System.out.println("获取到cookie值为: " + test);
        response.addCookie(new Cookie("test", "lbwnb"));
        return new ModelAndView("index");

    }

    @RequestMapping(value = "/index2")
    public ModelAndView index2(HttpSession session,
                               @SessionAttribute(value="test", required=false) String test) {

        session.setAttribute("test", "xxxx");
        System.out.println(test);
        return new ModelAndView("index");

    }

}
