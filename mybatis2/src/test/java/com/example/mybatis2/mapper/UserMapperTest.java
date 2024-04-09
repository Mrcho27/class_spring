package com.example.mybatis2.mapper;

import com.example.mybatis2.dto.SearchDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void selectByKeyword(){
        SearchDto searchDto = new SearchDto();
        searchDto.setCate("userId");
        searchDto.setKeyword("21");

        userMapper.selectByKeyword(searchDto,"M");
    }

    @Test
    void selectByGender(){
        List<String> genders = new ArrayList<>();
        genders.add("M");
        genders.add("F");

        userMapper.selectByGender(genders);
    }

}