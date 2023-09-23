package com.SpringMvcController.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/yy-ds1")
public class RequestMappingController2 {

    @RequestMapping({"/hello1", "hello2"})
    public String hello(Model model) {
        model.addAttribute("name", "阿哲"); return "index";
    }

    @RequestMapping({"/index1", "/index2"})
    public ModelAndView index1() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/index2", method = RequestMethod.POST)
    public ModelAndView index2() {
        return new ModelAndView("index");
    }

    @PostMapping(value = "/index3")
    public ModelAndView index3(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/index4", params = {"username", "password"})
    public ModelAndView index4() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/index5", params = {"!username", "password"})
    public ModelAndView index5() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/index6", params = {"username!=test", "password=123"})
    public ModelAndView index6() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/index7", headers = "!Connection")
    public ModelAndView index7() {
        return new ModelAndView("index");
    }

}
