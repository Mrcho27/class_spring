package com.example.finalapp.service;

import com.example.finalapp.dto.UserDto;
import com.example.finalapp.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public void registerUser(UserDto userDto){
        userMapper.insertUser(userDto);
    }

    public Long findId(String loginId, String password){
        return userMapper.selectId(loginId, password)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 회원 정보"));
    }
}
