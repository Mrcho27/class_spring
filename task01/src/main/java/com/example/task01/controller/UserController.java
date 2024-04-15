package com.example.task01.controller;

import com.example.task01.dto.UserDto;
import com.example.task01.exception.DuplicateUserException;
import com.example.task01.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("join")
    public void join(){}

    @GetMapping("/login")
    public void login(){}

    @PostMapping("/join")
    public String join(UserDto userDto){
        log.info("userDto = {}", userDto);

        try {
            userService.registerUser(userDto);
        } catch (DuplicateUserException e) {
            e.printStackTrace();
            return "user/join";
        }

        return "redirect:/user/login";
    }

    @PostMapping("/login")
    public String login(String loginId, String password, HttpSession session){
        try {
            Long userId = userService.findUserId(loginId, password);
            session.setAttribute("userId", userId);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "user/login";
        }

        return "redirect:/board/list";
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate(); //세션의 모든값 삭제

//        문자열 값으로 리다이렉트 하기
//        return "redirect:/user/login";

//        RedirectView 객체를 활용하여 리다이렉트 하기
        return new RedirectView("/user/login");
    }

//    @Controller 가 적용된 클래스에서 메서드에 @ResponseBody 어노테이션을 사용할 수 있다.
//    해당 어노테이션이 붙은 메서드는 반환하는 값을 응답의 Body에 저장하여 보내준다.
//    즉, 전체 HTML 코드를 통신하는 것이 아니라 원하는 데이터만 응답으로 보낼 수 있다.
    
    @ResponseBody
    @GetMapping("/test")
    public int test(){
        return 123;
    }
}
