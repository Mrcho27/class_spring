package com.example.mybatis2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String loginId;
    private String password;
    private String name;
    private String gender;
}
