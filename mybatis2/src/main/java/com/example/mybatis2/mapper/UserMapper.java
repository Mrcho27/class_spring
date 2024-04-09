package com.example.mybatis2.mapper;

import com.example.mybatis2.dto.SearchDto;
import com.example.mybatis2.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // mapper.xml에 전달되는 값이 여러개인 경우(매개변수가 여러개인경우)
    // 내부에서 자동으로 map으로 변환하여 넘겨준다.
    // 단, 여러 파라미터 중 Dto같은 객체 타입이 존재하는 경우
    // 각 파라미터별로 이름을 지어줘야한다.
    // 이름을 지을 때 사용하는 어노테이션이 @Param("이름") 이다.
    // mapper.xml에서는 값을 사용할 때 우리가 지어준 이름을 사용해야한다.
    List<UserDto> selectByKeyword(@Param("searchDto") SearchDto searchDto,
                                  @Param("gender") String gender);

    List<UserDto> selectByGender(List<String> genders);
}
