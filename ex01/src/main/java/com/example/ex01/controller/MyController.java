package com.example.ex01.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

// 스프링에서 요청을 처리하는 객체는 Controller이다.
// 이 클래스를 컨트롤러로 등록하기 위해 사용하는 어노테이션이 @Controller이다.
@Controller
public class MyController {

//    @RequestMapping 은 특정 url과 메서드를 매핑해준다.
//    매핑된 url로 요청이 들어오면 해당 메서드가 실행된다.
    @RequestMapping("/ex/01")
    public void ex01(){
        System.out.println("ex01() 실행!!!!");
    }

    @RequestMapping("/ex/02")
    public void ex02(){
        System.out.println("ex02() 실행!!!");
    }

//    클라이언트가 보내는 데이터를 꺼내어 사용하고 싶으면
//    기존의 HttpServletRequest 객체를 사용해도 되지만, 스프링에서는 이 방식을 권장하지 않는다.
//    스프링 프레임워크는 기존의 저수준 기술들을 편하게 쓸 수 있게 새로운 객체를 지원하거나 새로운 방식을 지원한다.
    @RequestMapping("/ex/03")
    public void ex03(HttpServletRequest req){
        System.out.println("ex03 실행@@@@@");
        System.out.println(req.getParameter("name"));
    }

//    Spring MVC를 사용하는 경우 데이터의 이름이 일치하는 매개변수를 만들어주면
//    자동으로 해당 데이터가 바인딩 된다.
    @RequestMapping("/ex/04")
    public void ex04(String name){
        System.out.println("ex04 실행#####");
        System.out.println(name);
    }

//    ex05를 만들고 name과 age를 동시에 받아서 출력한다.
//    데이터를 보낼 때는 쿼리스트링을 사용한다.
//    참고) 데이터를 여러개 보낼때는 & 를 사용한다.

    @RequestMapping("/ex/05")
    public void ex05(String name,int age){
        System.out.println("ex05 실행!!!");
        System.out.println(name);
        System.out.println(age);
    }
}
