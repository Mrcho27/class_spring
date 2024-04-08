package com.example.mybatis2.mapper;

import com.example.mybatis2.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberMapperTest {
    @Autowired
    MemberMapper memberMapper;

    @Test
    void insert(){
        MemberDto memberDto = new MemberDto();
        memberDto.setAge(22);
        memberDto.setName("test");

        System.out.println("memberDto = " + memberDto);

        memberMapper.insertMember(memberDto);

        System.out.println("memberDto = " + memberDto);
    }

    @Test
    void callByValue(){
        MemberDto memberDto = new MemberDto();
        memberDto.setAge(22);
        memberDto.setName("test");

        System.out.println("memberDto = " + memberDto);
        createPk(memberDto);
        System.out.println("memberDto = " + memberDto);
    }

    void createPk(MemberDto memberDto){
        memberDto.setMemberId(10L);
    }
}