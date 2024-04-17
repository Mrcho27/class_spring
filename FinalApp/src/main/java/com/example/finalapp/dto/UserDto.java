package com.example.finalapp.dto;

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
    private String gender;
    private String email;
    private String address;
    private String addressDetail;
    private String zipcode;
}