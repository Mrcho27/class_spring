package com.example.mybatis2.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper // 이 인터페이스를 매퍼로 등록한다.
public interface TimeMapper {
//    TimeMapper.xml의 namespace에 이 인터페이스를 매핑을 해놨다면 자동으로 연결된다.
//    연결된 xml에 쿼리 id와 동일한 메서드 이름을 사용하면 알아서 매핑된다.
    String selectTime();

    @Select("SELECT SYSDATE FROM DUAL")
    String selectTime2();
}
