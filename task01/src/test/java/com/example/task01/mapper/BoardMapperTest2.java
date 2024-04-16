package com.example.task01.mapper;

import com.example.task01.dto.BoardDetailDto;
import com.example.task01.dto.BoardDto;
import com.example.task01.dto.BoardListDto;
import com.example.task01.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardMapperTest2 {

    @Autowired
    BoardMapper boardMapper;
    @Autowired
    UserMapper userMapper;

    BoardDto boardDto;
    UserDto userDto;

    @BeforeEach
    void setUp() {
        userDto = new UserDto();
        userDto.setLoginId("aaa");
        userDto.setPassword("1234");
        userDto.setName("test");
        userDto.setAddress("노원구");
        userDto.setAddressDetail("5층");
        userDto.setZipcode("12345");
        userDto.setGender("M");

        userMapper.insertUser(userDto);

        boardDto = new BoardDto();
        boardDto.setTitle("test title");
        boardDto.setContent("test content");
        boardDto.setUserId(userDto.getUserId());

        boardMapper.insertBoard(boardDto);
    }

    @Test
    void insertBoard() {
    }

    @Test
    void selectAll() {
        List<BoardListDto> boardList = boardMapper.selectAll();

        assertThat(boardList)
                .isNotEmpty()
                .hasSize(1);

        assertThat(boardList)
                .extracting("title")
                .contains("test title");
    }

    @Test
    void selectById() {
        BoardDetailDto boardDetailDto = boardMapper.selectById(boardDto.getBoardId()).orElse(null);

        assertThat(boardDetailDto.getTitle()).isEqualTo(boardDto.getTitle());

        assertThat(boardDetailDto)
                .isNotNull()
                .extracting("title")
                .isEqualTo(boardDetailDto.getTitle());
    }




}