package com.example.mybatis2.mapper;

import com.example.mybatis2.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void insertMember(MemberDto memberDto);
    MemberDto selectMember(Long memberId);
    List<MemberDto> selectList();
    void updateMember(MemberDto memberDto);

    void deleteMember(Long memberId);
}
