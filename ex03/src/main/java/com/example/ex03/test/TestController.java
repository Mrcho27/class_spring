package com.example.ex03.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/ex01")
    public void ex01(Model model){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            list.add(i);
        }

        model.addAttribute("list",list);
    }

    @GetMapping("/ex02")
    public void ex02(Model model){
        model.addAttribute("role","member");
        model.addAttribute("number", 10);
        model.addAttribute("data", "");
    }

    @GetMapping("/main")
    public void enterMain(){

    }
}
