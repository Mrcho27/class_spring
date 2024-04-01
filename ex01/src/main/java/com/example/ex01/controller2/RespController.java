package com.example.ex01.controller2;

import com.example.ex01.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resp")
public class RespController {
    @GetMapping("/01")
    public String resp01(){
        return "hello";
    }

    @GetMapping("/join")
    public String join(){
        return "member/join";
    }

    @PostMapping("/join")
    public String joinOk(UserDto userDto){
        System.out.println("userDto = " + userDto);
        return "hello";
    }

    //    실습
//    로그인 구현하기
//    1. member/login.html 파일을 생성하고 loginId와 password를 입력받는 칸을 만든다.
//    2. 로그인 페이지 진입용 URL은 GET/ resp/login
//    3. 서브밋 버튼을 누르면 로그인 처리를 진행한다.
//    4. 로그인 처리용 URL은 POST /resp/login
//    5. 로그인 처리를 할 때 받아온 데이터를 출력하고 hello.html 페이지로 화면을 전환한다.

    @GetMapping("/login")
    public String login(){
        return "member/login";
    }

    @PostMapping("/login")
    public String loginOk(UserDto userDto){
        System.out.println("userDto = " + userDto);
        return "hello";
    }

}
