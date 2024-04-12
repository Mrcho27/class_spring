package com.example.task01.mapper;

import com.example.task01.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void insertUser() {
        UserDto userDto = new UserDto();
        userDto.setLoginId("aaa");
        userDto.setPassword("1234");
        userDto.setName("test");
        userDto.setAddress("노원구");
        userDto.setAddressDetail("5층");
        userDto.setZipcode("12345");
        userDto.setGender("M");

        userMapper.insertUser(userDto);
    }

    @Test
    void selectUserId() {
        Long UserId = userMapper.selectUserId("aaa", "1234")
                .orElse(null);
        System.out.println("UserId = " + UserId);
    }

    @Test
    void selectByLoginId(){
        int count = userMapper.selectByLoginId("aaa");
        System.out.println("count = " + count);
    };
}