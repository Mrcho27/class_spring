package com.example.layer01.mapper;

import com.example.layer01.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberMapperTest {
    @Autowired
    MemberMapper memberMapper;

    @Test
    void insertMember() {
        MemberDto memberDto = new MemberDto();
        memberDto.setName("홍길동");
        memberDto.setAge(56);

        memberMapper.insertMember(memberDto);
    }

    @Test
    void selectMember() {
//        MemberDto foundMember = memberMapper.selectMember(21L);
//        System.out.println("foundMember = " + foundMember);

    }
}