package com.example.layer01.controller;

import com.example.layer01.dto.MemberDto;
import com.example.layer01.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public void join(MemberDto memberDto){
        memberService.registerMember(memberDto);
    }

    @GetMapping("/search")
    public void search(Long memberId) {
        try {
            MemberDto foundMember = memberService.findMember(memberId);
            log.info("foundMember = {}",foundMember);
//            return "main";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            log.info("잘못된 입력!!!");
//            return "member/login";
        }
    }
}
