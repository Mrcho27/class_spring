package com.example.ex04.controller;

import com.example.ex04.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class Mycontroller {
    @Autowired
    private MyService myService;

    @GetMapping("/di")
    public String di(){
        return "my/di";
    }

    @PostMapping("/di")
    public String di(String name, int age, String address, Model model){

//        MyService myService =new MyService();
        int resultAge = myService.ageProcess(age);

        model.addAttribute("name", name);
        model.addAttribute("age", resultAge);
        model.addAttribute("address", address);
        return "my/result";
    }
}
