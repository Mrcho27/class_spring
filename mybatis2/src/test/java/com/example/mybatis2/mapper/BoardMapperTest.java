package com.example.mybatis2.mapper;

import com.example.mybatis2.dto.BoardDto;
import com.example.mybatis2.dto.SearchDto;
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
        boardDto.setTitle("test title3");
        boardDto.setContent("test content3");
        boardDto.setWriter("ccc");

        boardMapper.insertBoard(boardDto);
    }

    @Test
    void selectByKeyword(){
        SearchDto searchDto = new SearchDto();
        searchDto.setCate("writer");
        searchDto.setKeyword("c");

        List<BoardDto> boardList = boardMapper.selectByKeyword(searchDto);
        System.out.println("boardList = " + boardList);

    }
}