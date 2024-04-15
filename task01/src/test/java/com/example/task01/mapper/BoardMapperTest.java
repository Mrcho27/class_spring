package com.example.task01.mapper;

import com.example.task01.dto.BoardDto;
import com.example.task01.dto.BoardListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardMapperTest {
    @Autowired
    BoardMapper boardMapper;

    @Test
    void insertBoard() {
        BoardDto boardDto = new BoardDto();
        boardDto.setTitle("test title");
        boardDto.setContent("test content");
        boardDto.setUserId(1L);

        boardMapper.insertBoard(boardDto);
    }

    @Test
    void selectAll(){
        List<BoardListDto> boardList = boardMapper.selectAll();
        System.out.println("boardList = " + boardList);
    }
}