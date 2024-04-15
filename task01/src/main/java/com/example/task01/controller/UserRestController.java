package com.example.task01.controller;

import com.example.task01.dto.UserDto;
import com.example.task01.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController 는 @Controller + @ResponseBody 을 합쳐놓은 어노테이션이다.
// 이 클래스의 메소드들이 반환하는 값은 모두 데이터이다.(View가 아님)
@RestController
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping("/users")
    public String test(String loginId){
        System.out.println("loginId = " + loginId);
        int count = userService.findByLoginId(loginId);

        return count > 0 ? "중복된 아이디입니다" : "사용가능한 아이디입니다!";
    }

    @GetMapping("/users/test")
    public UserDto test2(){
        UserDto userDto = new UserDto();
        userDto.setLoginId("aaa");
        userDto.setPassword("1234");
        userDto.setGender("F");
        userDto.setName("test");
        return userDto;
    }
}
