package com.example.task01.mapper;

import com.example.task01.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void insertUser(UserDto userDto);

    Optional<Long> selectUserId(@Param("loginId") String loginId,
                               @Param("password") String password);

    int selectByLoginId(String loginId);
}
