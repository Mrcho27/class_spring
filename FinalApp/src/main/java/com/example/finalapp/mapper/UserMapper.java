package com.example.finalapp.mapper;

import com.example.finalapp.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void insertUser(UserDto userDto);

    Optional<Long> selectId(@Param("loginId") String loginId,
                           @Param("password") String password);
}
