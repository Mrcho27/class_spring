package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class LoginController {
    @GetMapping("/login")
    public void login(){

    }

    @PostMapping("/login")
    public String login(String loginId,String password){
        System.out.println("loginId = " + loginId + ", password = " + password);
        if (loginId.equals("admin")){
            return "task/admin";
        }else {
            return "task/main";
        }
    }
}
