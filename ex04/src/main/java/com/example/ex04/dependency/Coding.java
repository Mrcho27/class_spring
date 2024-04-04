package com.example.ex04.dependency;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//주입을 당하는 클래스와 주입을 받는 클래스는 모두 스프링에 등록되어야한다.
//스프링에 등록하는 가장 기본적인 어노테이션이 @Component이다.
@Component
@Data
// final이 붙은 필드를 초기화해주는 생성자를 만들어준다.(롬복에서 지원)
// computer를 초기화하는 생성자를 만들어주면 생성자가 1개이기 때문에 자동으로 @Autowired가 붙는다.
@RequiredArgsConstructor
public class Coding {
//    @Autowired 필드 주입
    private final Computer computer;

//    생성자 주입
//    @Autowired // 생성자가 1개만 존재하는 경우 @Autowired를 생략해도 자동으로 붙여준다.
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}
