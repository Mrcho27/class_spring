package com.example.mybatis2.mapper;

import com.example.mybatis2.dto.SearchDto;
import com.example.mybatis2.dto.UserDto;
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

    @Test
    void selectByKeyword2(){
        SearchDto searchDto = new SearchDto();
        searchDto.setCate("loginId");
        searchDto.setKeyword("a");

//        List의 of() 메서드로 편하게 리스트 생성과 동시에 값을 넣을 수 있다.
        List<String> genders = List.of("M", "F");
//        of()로 생성한 리스트는 Immutable(불변)객체이다.
//        데이터 추가/삭제/수정을 할 수 없다.
//        genders.add("N");

        List<UserDto> userList = userMapper.selectByKeyword2(searchDto, genders);
    }

}