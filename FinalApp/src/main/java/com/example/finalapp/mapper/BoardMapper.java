package com.example.finalapp.mapper;

import com.example.finalapp.dto.BoardListDto;
import com.example.finalapp.dto.BoardUpdateDto;
import com.example.finalapp.dto.BoardViewDto;
import com.example.finalapp.dto.BoardWriteDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void insertBoard(BoardWriteDto boardWriteDto);

    void deleteBoard(Long boardId);

    void updateBoard(BoardUpdateDto boardUpdateDto);

    Optional<BoardViewDto> selectById(Long boardId);

    List<BoardListDto> selectAll();
}
