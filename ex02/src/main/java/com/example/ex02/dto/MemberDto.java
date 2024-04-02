package com.example.ex02.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String loginId;
    private String password;
    private int age;
    private String name;
}
