package com.example.ex01.controller;

import com.example.ex01.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DtoController {

    @RequestMapping("/dto/01")
    public void dto01(String name, int age, String gender){
        MemberDto memberDto = new MemberDto();
        memberDto.setName(name);
        memberDto.setAge(21);
        memberDto.setGender(gender);

        System.out.println(memberDto);
    }

    @RequestMapping("/dto/02")
    public void dto02(MemberDto memberDto){
        System.out.println(memberDto);
    }
}
