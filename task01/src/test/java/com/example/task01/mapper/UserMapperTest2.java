package com.example.task01.mapper;

import com.example.task01.dto.UserDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
// 테스트 클래스에서 @Transactional을 사용하면
// @Test메서드가 종료될 때 자동으로 롤백해준다.
@Transactional
class UserMapperTest2 {
    @Autowired
    UserMapper userMapper;

    UserDto userDto;

    @BeforeEach
    void setUp(){
        userDto = new UserDto();
        userDto.setLoginId("aaa");
        userDto.setPassword("1234");
        userDto.setName("test");
        userDto.setAddress("노원구");
        userDto.setAddressDetail("5층");
        userDto.setZipcode("12345");
        userDto.setGender("M");

        userMapper.insertUser(userDto);
    }

    @Test
    void insertUser(){
//        UserDto userDto = new UserDto();
//        userDto.setLoginId("aaa");
//        userDto.setPassword("1234");
//        userDto.setName("test");
//        userDto.setAddress("노원구");
//        userDto.setAddressDetail("5층");
//        userDto.setZipcode("12345");
//        userDto.setGender("M");
//
//        userMapper.insertUser(userDto);
    }

//    Unit Test(단위 테스트)
//    소스 코드 중 특정 모듈이 개발자가 의도한 대로 작동하는지 검증하는 절차이다.
//    함수나 메소드의 테스트 케이스를 만드는 절차이며, 코드 변경으로 인한 문제가 발생한 경우
//    빠른 시간 내에 파악하고 수정할 수 있도록 도와준다.
//    가장 이상적인 테스트 방법은 각 테스트 별로 서로 간섭해서는 안되며, 항상 같은 결과를
//    기대할 수 있어야한다.

//    JUnit
//    자바 어플리케이션의 단위 테스트를 쉽게 해주는 프레임워크이다.
//    assert 메소드와 @Test, @Before, @After 등의 어노테이션을 지원한다.

    @Test
    void selectUserId(){
        Optional<Long> opt = userMapper.selectUserId("aaa", "1234");
        Long userId = opt.get();
        System.out.println("userId = " + userId);

//        JUnit에서 제공하는 Assert 메소드
//        테스트 코드에서 검증을 하기위한 메소드를 지원한다.

//        assertEquals(a, b) : a, b의 값이 같은지 확인
        Assertions.assertEquals(userDto.getUserId(), userId);

//        assertArrayEquals(a,b) : a, b 배열이 같은지 확인
//        assertSame(a,b) : a, b 객체의 참조값이 같은지 확인
//        기타 등등... 여러 검증 메서드를 지원한다.
    }

//    AssertJ
//    JUnit의 테스트 코드에 사용하는 라이브러리이다.
//    JUnit에서 제공하는 Assert메소드 보다 더 직관적이고 사용하기 쉽게 만들었다.
    @Test
    void stringTest(){
//        AssertJ 메서드
//        기본 사용은 assertThat()으로 시작한다.
//        assertThat(타겟).메소드1().메소드2()....
//        위와 같이 메서드 체이닝 방식으로 검증 코드를 작성할 수 있다.
//        검증 메서드는 이름만 봐도 기능을 알 정도로 직관적이기 때문에 사용방법이 매우 간편하다.

        assertThat("안녕하세요! 반갑습니다!")
                .isNotNull()
                .contains("반갑")
                .startsWith("안");

//        예외 검증을 하는 assertThatThrownBy(예외가 발생될 코드) 메서드도 지원한다.
        assertThatThrownBy(() -> {throw new NumberFormatException("number"); })
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("num");
    }

    @Test
    void selectUserId2(){
        Long userId = userMapper.selectUserId("aaa", "1234").get();

        assertThat(userId)
                .isNotNull()
                .isEqualTo(userDto.getUserId());
    }

    @Test
    void selectByLoginId(){
        int count = userMapper.selectByLoginId("aaa");

        assertThat(count).isEqualTo(1);

    }
}