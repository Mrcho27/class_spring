package com.example.finalapp.service;

import com.example.finalapp.dto.user.UserDto;
import com.example.finalapp.mapper.user.UserMapper;
import com.example.finalapp.service.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    UserMapper userMapper;
    @InjectMocks
    UserService userService;

    @Test
    void registerUser() {
        // given
        Mockito.doNothing().when(userMapper).insertUser(any());
        // when
        userService.registerUser(new UserDto());
        // then
        Mockito.verify(userMapper, Mockito.times(1)).insertUser(any());
    }





    @Test
    void findId() {
        // given
        doReturn(Optional.of(1L)).when(userMapper).selectId(any(), any());
        // when
        Long userId = userService.findId("asdf", "asdg");
        // then
        Assertions.assertThat(userId).isEqualTo(1L);
    }
}