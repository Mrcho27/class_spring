package com.example.task01.service;

import com.example.task01.dto.UserDto;
import com.example.task01.exception.DuplicateUserException;
import com.example.task01.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public void registerUser(UserDto userDto) throws DuplicateUserException{
        int count = userMapper.selectByLoginId(userDto.getLoginId());

        if(count > 0){
            throw new DuplicateUserException("중복된 아이디입니다!.");
        }

        userMapper.insertUser(userDto);
    }

    public Long findUserId(String loginId, String password){
        return userMapper.selectUserId(loginId, password)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 인증 정보"));
    }

    public int findByLoginId(String loginId){
        return userMapper.selectByLoginId(loginId);
    }

}
