package com.example.finalapp.controller;

import com.example.finalapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/join")
    public String join(){
        return "user/join";
    }

    @GetMapping("/login")
    public String login(){
        return  "user/login";
    }
}
