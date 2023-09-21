package com.SpringMvcController.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/yy-ds1")
public class RequestMappingController2 {

    /*@RequestMapping({"/hello1", "hello2"})
    public String hello(Model model) {
        model.addAttribute("name", "阿哲"); return "index";
    }*/

    /*@RequestMapping({"/index1", "/index2"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }*/

    /*@RequestMapping(value = "/index", method = RequestMethod.POST)
    public ModelAndView index() {
        return new ModelAndView("index");
    }*/

    /*@PostMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }*/

    /*@RequestMapping(value = "/index", params = {"username", "password"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }*/

    /*@RequestMapping(value = "/index", params = {"!username", "password"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }*/

    /*@RequestMapping(value = "/index", params = {"username!=test", "password=123"})
    public ModelAndView index() {
        return new ModelAndView("index");
    }*/

    @RequestMapping(value = "/index", headers = "!Connection")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}
