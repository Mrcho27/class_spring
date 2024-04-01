package com.example.ex01.dto;

import lombok.*;

//롬복에서 지원하는 여러 어노테이션
//개발을 할 때 반복적으로 항상 같은 틀을 만들게 되는데 롬복을 사용하면
//어노테이션으로 getter, setter, toString 등을 쉽게 만들 수 있다.
//@Getter @Setter @ToString @EqualsAndHashCode
@Data
//@NoArgsConstructor @AllArgsConstructor
public class MemberDto {
    private String name;
    private int age;
    private String gender;
}
