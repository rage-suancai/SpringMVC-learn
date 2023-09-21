package com.SpringMvcController.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelAndViewController1 {

    @RequestMapping("/index1")
    public ModelAndView index1() {
        return new ModelAndView("index");
    }
    @RequestMapping("/index2")
    public ModelAndView index2() {

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.getModel().put("name", "啊这"); return modelAndView;

    }

    @RequestMapping("/index3")
    public String index3() {
        return "index";
    }
    @RequestMapping("/index4")
    public String index4(Model model) {
        model.addAttribute("name", "啊这"); return "index";
    }

}
