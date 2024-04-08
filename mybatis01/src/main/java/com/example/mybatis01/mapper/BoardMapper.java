package com.example.mybatis01.mapper;

import com.example.mybatis01.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDto boardDto);
    BoardDto selectBoard(Long boardId);

    List<BoardDto> selectAll();
    void updateBoard(BoardDto boardDto);

    void deleteBoard(Long boardId);
}
