package com.example.layer01.mapper;

import com.example.layer01.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    void insertMember(MemberDto memberDto);

    Optional<MemberDto> selectMember(Long memberId);


}
