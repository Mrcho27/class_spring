package com.example.task01.service;

import com.example.task01.dto.UserDto;
import com.example.task01.exception.DuplicateUserException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void registerUser() {
        UserDto userDto = new UserDto();
        userDto.setLoginId("bbb");
        userDto.setPassword("1234");
        userDto.setName("bbb");
        userDto.setAddress("강남구");
        userDto.setAddressDetail("5층");
        userDto.setZipcode("12345");
        userDto.setGender("M");

        try {
            userService.registerUser(userDto);
        } catch (DuplicateUserException e) {
            System.out.println("중복된 아이디!!!");
            e.printStackTrace();
        }
    }

    @Test
    void findUserId() {
        Long foundUserId = null;
        try {
            foundUserId = userService.findUserId("aaa", "12345");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("foundUserId = " + foundUserId);
    }
}