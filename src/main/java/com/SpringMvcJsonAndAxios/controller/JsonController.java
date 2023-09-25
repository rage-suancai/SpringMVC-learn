package com.SpringMvcJsonAndAxios.controller;

import com.SpringMvcJsonAndAxios.entity.Student;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/json")
public class JsonController {

    @RequestMapping("/index1")
    public String index1() {

        JSONObject object = new JSONObject();
        object.put("name", "杰哥"); object.put("age", 18);
        System.out.println(object.toJSONString());
        return "index";

    }

    @RequestMapping("/index2")
    public String index2() {

        JSONObject object = new JSONObject();
        JSONArray array = new JSONArray();

        object.put("name", "杰哥"); object.put("age", 18);
        array.add(object);
        System.out.println(array.toJSONString());
        return "index";

    }

    @RequestMapping(value = "/index3", produces = "application/json")
    public Student index3() {

        Student student = new Student();
        student.setName("杰哥"); student.setAge(18);
        // return JSON.toJSONString(student);
        return student;

    }

}
