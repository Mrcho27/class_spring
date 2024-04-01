package com.example.ex01.controller;

import com.example.ex01.dto.BoardDto;
import com.example.ex01.dto.MemberDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//url 매핑을 할 때 공통되는 상위 경로가 있다면
// 클래스에 @RequestMapping()으로 상위 경로 설정을 할 수 있다.
@RequestMapping("/test")
public class ReqMethodController2 {

    @GetMapping("/01") // url : /test/01
    public void test01(){
        System.out.println("ReqMethodController2.test01");
    }

    @GetMapping("/02") // url : /test/02
    public void test02(){
        System.out.println("ReqMethodController2.test02");
    }

//    실습
//    test03() 메서드를 만든다.
//    요청 : GET / test/03
//    파라미터 : name=김철수, age=11, gender=M
//    전부 받아서 출력하기
    @GetMapping("/03")
    public void test03(MemberDto memberDto){
        System.out.println("memberDto = " + memberDto);
    }

//    test04() 메서드를 만든다.
//    요청 : GET /test04/04
//    파라미터 : title=hi, content= 안녕하세요
//    BoardDto를 생성하여 사용하기
//    전부 받아서 출력하기
    @GetMapping("/04")
    public void test04(BoardDto boardDto){
        System.out.println("boardDto = " + boardDto);
    }
}
