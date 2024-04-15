package com.example.task01.mapper;

import com.example.task01.dto.BoardDetailDto;
import com.example.task01.dto.BoardDto;
import com.example.task01.dto.BoardListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardDto boardDto);

    List<BoardListDto> selectAll();
    Optional<BoardDetailDto> selectById(Long boardId);
}
