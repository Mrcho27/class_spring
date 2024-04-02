package com.example.ex02.controller;

import com.example.ex02.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;

@Controller
@RequestMapping("/mvc2")
public class MvcController2 {

    @GetMapping("/join")
    public void join(){

    }

    @PostMapping("/join")
    public String join(MemberDto memberDto, Model model){
        System.out.println("memberDto = " + memberDto);

//        html에 데이터를 보낼때 Model객체를 사용한다.
//        만약 Dto같은 객체가 가진 데이터를 보내고 싶다면 Dto를 통으로 넣으면 된다.
        model.addAttribute("memberDto", memberDto);

        return "mvc2/result";
    }

    @GetMapping("/list01")
    public void list01(){
    }

    @PostMapping("/list01")
//    사용자가 입력한 값을 가져올 때 태그의 name속성이 동일하다면
//    같은 name으로 여러 값을 받아야한다. -> List를 사용
//    매개변수를 List 타입으로 설정한다면 @RequestParam()을 사용하여 데이터를 바인딩해준다.
    public void list01(@RequestParam("color") List<String> colors){
        System.out.println("colors = " + colors);
    }

}
