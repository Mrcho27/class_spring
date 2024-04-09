package com.example.mybatis2.controller;

import com.example.mybatis2.dto.SearchDto;
import com.example.mybatis2.dto.UserDto;
import com.example.mybatis2.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper userMapper;

    @GetMapping("/list")
    public String userList(SearchDto searchDto,String gender, Model model){
        log.info("gender = {}", gender);
        log.info("searchDto = {}", searchDto);

        List<UserDto> userList = userMapper.selectByKeyword(searchDto,gender);
        model.addAttribute("userList", userList);

        return "user/list";
    }
}
