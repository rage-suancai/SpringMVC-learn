package com.SpringMvcJsonAndAxios.controller;

import com.SpringMvcJsonAndAxios.entity.Student;
import com.SpringMvcJsonAndAxios.entity.User;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/axios")
public class AxiosController {

    @GetMapping("/index")
    public String index() {
        return "axios";
    }

    @ResponseBody
    @GetMapping(value = "/axios1", produces = "application/json")
    public Student axios1() {

        Student student = new Student();
        student.setName("johnCarmack"); student.setAge(22);
        return student;

    }

    @ResponseBody
    @PostMapping(value = "/login1", produces = "application/json")
    public String login1(String username, String password) {

        JSONObject object = new JSONObject();
        boolean success = "johnCarmack".equals(username) && "123456".equals(password);

        object.put("success", success); return object.toString();

    }

    @ResponseBody
    @PostMapping(value = "/login2", produces = "application/json")
    public String login2(@RequestBody User user) {

        JSONObject object = new JSONObject();
        boolean success = "johnCarmack".equals(user.getUsername()) && "123456".equals(user.getPassword());

        object.put("success", success); return object.toString();

    }

}
