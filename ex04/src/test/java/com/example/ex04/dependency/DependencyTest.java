package com.example.ex04.dependency;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 현재 클래스를 테스트 클래스로 사용하기 위해 붙이는 어노테이션
@SpringBootTest
public class DependencyTest {
//    바로 다음에 나오는 필드에 의존성 주입을 받는다.
    @Autowired
    Coding coding;

//    해당 메서드를 테스트 메서드로 등록한다.
//    테스트 메서드는 독립적으로 실행이 가능해진다.
    @Test
    void diTest(){
        System.out.println("coding = " + coding);
//        의존성 주입이 되지 않았다면 결과가 null로 나올 것이다.
    }
}
