package com.example.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReqMethodController {
//    기존의 @RequestMapping 을 사용할 때 ()안에 url 패턴을 작성하면
//    자동으로 value라는 옵션에 설정된다.
//    @RequestMapping("/method/01")

//    만약에 어노테이션 옵션을 여러개 설정하고 싶다면
//    반드시 옵션 이름을 명시해야한다.
    @RequestMapping(value = "/method/01", method = RequestMethod.GET)
    public void method01(){
        System.out.println("ReqMethodController.method01");
    }

    @GetMapping("/method/02")
    public void method02(){
        System.out.println("ReqMethodController.method02");
    }
}
