package com.SpringMvcExceptions.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String error(Exception e, Model model) {

        e.printStackTrace();
        model.addAttribute("e", e); return "500";

    }

}
