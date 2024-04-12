package com.example.layer01.service;

import com.example.layer01.dto.MemberDto;
import com.example.layer01.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


// 하나의 서비스 메서드에서 여러 쿼리를 사용할 때 1개의 쿼리라도 오류가 발생되면
// 모든 쿼리가 롤백되어야한다.
// 그렇기 위해서는 트랜잭션 처리를 해줘야하는데 매번 개발자가 트랜잭션을 열고 커밋하고 롤백하는
// 코드를 작성하면 불편하다.
// 스프링에서는
// @Transactional을 달아주면 자동으로 트랜잭션 처리를 해준다. (서비스에서만 사용할 것)
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public void registerMember(MemberDto memberDto){
        memberMapper.insertMember(memberDto);
    }

    public MemberDto findMember(Long memberId){
        MemberDto foundMember = memberMapper.selectMember(memberId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원번호!!"));
        String name = foundMember.getName();

        foundMember.setName(name + "님");

        return foundMember;
    }
}
