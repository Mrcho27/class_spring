package com.example.layer01.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class MemberDto {
    private Long memberId;
    private String name;
    private int age;
}
