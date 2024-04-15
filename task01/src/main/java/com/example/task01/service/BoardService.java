package com.example.task01.service;

import com.example.task01.dto.BoardDetailDto;
import com.example.task01.dto.BoardDto;
import com.example.task01.dto.BoardListDto;
import com.example.task01.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;
    public void registerBoard(BoardDto boardDto) {
        boardMapper.insertBoard(boardDto);
    }

    public List<BoardListDto> findAll(){
        return boardMapper.selectAll();
    }

    public BoardDetailDto findById(Long boardId){
        return boardMapper.selectById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 게시물 정보"));
    }
}
