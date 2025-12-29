package com.example.FirstSpringMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //@RequestMapping("/message")
    @RequestMapping
    public String message(){
        return "home"; //view name all other location and extension specify in application.yml file
    }
}
