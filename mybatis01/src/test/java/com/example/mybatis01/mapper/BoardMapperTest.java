package com.example.mybatis01.mapper;

import com.example.mybatis01.dto.BoardDto;
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
        boardDto.setTitle("test title2");
        boardDto.setContent("test content2");
        boardDto.setWriter("vvv");
        boardMapper.insertBoard(boardDto);
    }

    @Test
    void selectBoard() {
        BoardDto foundBoard = boardMapper.selectBoard(1L);
        System.out.println("foundBoard = " + foundBoard);
    }

    @Test
    void selectAll() {
        List<BoardDto> boardList = boardMapper.selectAll();
        System.out.println("boardList = " + boardList);
    }

    @Test
    void updateBoard() {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardId(1L);
        boardDto.setTitle("update title");
        boardDto.setContent("update content");
        boardMapper.updateBoard(boardDto);
    }

    @Test
    void deleteBoard() {
        boardMapper.deleteBoard(2L);
    }
}