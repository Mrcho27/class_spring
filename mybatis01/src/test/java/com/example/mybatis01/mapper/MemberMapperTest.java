package com.example.mybatis01.mapper;

import com.example.mybatis01.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberMapperTest {
    @Autowired
    MemberMapper memberMapper;

    @Test
    void insertMember(){
        MemberDto memberDto = new MemberDto();
        memberDto.setName("김철수");
        memberDto.setAge(11);

        memberMapper.insertMember(memberDto);
    }

    @Test
    void selectMember(){
        MemberDto foundMember = memberMapper.selectMember(1L);
        System.out.println("foundMember = " + foundMember);
    }

    @Test
    void selectList(){
        List<MemberDto> memberList = memberMapper.selectList();
        System.out.println("memberList = " + memberList);
    }

    @Test
    void updateMember(){
        MemberDto memberDto = new MemberDto();
        memberDto.setMemberId(1L);
        memberDto.setName("update");
        memberDto.setAge(55);

        memberMapper.updateMember(memberDto);
    }

    @Test
    void deleteMember(){
        memberMapper.deleteMember(1L);
    }
}