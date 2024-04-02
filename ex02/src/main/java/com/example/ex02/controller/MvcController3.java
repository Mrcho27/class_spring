package com.example.ex02.controller;

import com.example.ex02.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/mvc3")
public class MvcController3 {

    @GetMapping("/ex01")
    public void ex01() {
    }

    //    @PostMapping("/ex01")
//    public void ex01(MemberDto memberDto,
//                     String gender,// dto로 받을 수 없는 추가 데이터는 별도의 매개변수로 받으면 된다.
//                     @RequestParam("food") List<String> foods // 추가 데이터의 제한이 없으며 리스트 사용도 가능하다.
//    ){
//        System.out.println("memberDto = " + memberDto + ", gender = " + gender + ", foods = " + foods);
//    }

    @PostMapping("/ex01")
    public String ex01(MemberDto memberDto,
                       String gender,
//                       required 옵션은 필수 여부를 설정하는 옵션이다.
//                       true가 default이기 때문에 food라는 데이터를 안넘기면 오류가 발생된다.
//                       만약 안넘겨도 오류 없이 진행하고 싶다면 false로 설정해주면 된다.
                       @RequestParam(value = "food", required = false) List<String> foods,
                       Model model
    ) {
        System.out.println("memberDto = " + memberDto + ", gender = " + gender + ", foods = " + foods);
        model.addAttribute("member",memberDto);
        model.addAttribute("gender",gender);
        model.addAttribute("foods",foods);

        return "mvc3/result01";
    }

}
