package com.example.mybatis2.mapper;

import com.example.mybatis2.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardMapperTest {
    @Autowired
    BoardMapper boardMapper;

    @Test
    void insertBoard() {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("test title5");
        boardDto.setContent("test content5");
        boardDto.setWriter("ddd");

        boardMapper.insertBoard(boardDto);
    }
}