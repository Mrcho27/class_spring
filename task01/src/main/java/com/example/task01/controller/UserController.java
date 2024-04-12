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

        return "board/list";
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate(); //세션의 모든값 삭제

//        문자열 값으로 리다이렉트 하기
//        return "redirect:/user/login";

//        RedirectView 객체를 활용하여 리다이렉트 하기
        return new RedirectView("/user/login");
    }
}
