package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mvc")
public class MvcController {

    @GetMapping("/join")
    public void join(){
//        반환타입이 void인 경우는 해당 메서드의 url경로를 기반으로 html파일을 찾는다.
//        현재 join()메서드의 url경로는 /mvc/join이므로
//        templates/mvc/join.html을 찾아서 응답으로 보내게된다.
//        return "mvc/join";
    }
    @PostMapping("/join")
    public String join(@RequestParam("userName") String name, int age, Model model){
        System.out.println("name = " + name + ", age = " + age);
        model.addAttribute("userName", name);
        model.addAttribute("userAge", age);

        return "mvc/result";
    }
}
