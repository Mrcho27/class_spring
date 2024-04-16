package com.example.task01.service;

import com.example.task01.dto.UserDto;
import com.example.task01.exception.DuplicateUserException;
import com.example.task01.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

// Mockito란?
// mock을 만들고 mock의 행동을 정의하는 stubbing과 작동하는지에 대한 검증을 할 수 있는
// verify 등 다양한 기능을 제공해주는 프레임워크

// JUnit에서 Mockito 사용하기
// Junit과 Mockito는 둘 다 프레임워크이기 때문에 서로 결합하여 사용하기 위해서는 추가 설정이 필요하다.
// JUnit5 에서는 @ExtetndWith(MockitoExtension.class) 를 사용하면 기능이 확장된다.
@ExtendWith(MockitoExtension.class)
class UserServiceTest2 {
//    Mock 객체란?
//    어떤 객체를 모방하는 가짜 객체이다. 껍데기만 있으며 내부 구현부는 존재하지 않는다.
//    Mock객체를 만드는 것을 Mocking이라고 한다.

//    Mockito에서 지원하는 어노테이션
//    @Mock : Mock객체를 만들어준다.
//    @InjectMocks : Mock 객체를 주입해준다.
    @Mock
    UserMapper userMapper;
    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void registerUser() throws DuplicateUserException {
//        스터빙(Stubbing)
//        Mock객체의 메서드를 실행 했을 때의 행위를 미리 정의하는 것
//        (Mock객체의 특정 메소드를 실행시키면 특정 값을 반환하거나 예외를 발생 시키는 등을 설정한다.)

//        스텁(stub) : 스터빙으로 새롭게 정의된 메서드

//        given(준비)
        doReturn(0).when(userMapper).selectByLoginId(any());
        doNothing().when(userMapper).insertUser(any());

//        when(실행)
        userService.registerUser(new UserDto());

//        then(검증)
        verify(userMapper, times(1)).insertUser(any());
    }

    @Test
    void findUserId() {
        //given
        doReturn(Optional.of(1L)).when(userMapper).selectUserId(any(), any());

        //when
        Long userId = userService.findUserId("a", "123");

        //then
        assertThat(userId).isEqualTo(1L);
    }

    @Test
    void findUserIdException(){
//        given
        doReturn(Optional.empty()).when(userMapper).selectUserId(any(), any());

//        when
//        then
        assertThatThrownBy(() -> userService.findUserId("a", "111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("잘못된");

    }

    @Test
    void findByLoginId() {
    }
}