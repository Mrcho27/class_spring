package com.example.finalapp.service;


import com.example.finalapp.dto.BoardListDto;
import com.example.finalapp.dto.BoardUpdateDto;
import com.example.finalapp.dto.BoardViewDto;
import com.example.finalapp.dto.BoardWriteDto;
import com.example.finalapp.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public void registerBoard(BoardWriteDto boardWriteDto){
        boardMapper.insertBoard(boardWriteDto);
    }

    public void removeBoard(Long boardId){
        boardMapper.deleteBoard(boardId);
    }

    public void modifyBoard(BoardUpdateDto boardUpdateDto){
        boardMapper.updateBoard(boardUpdateDto);
    }

    public BoardViewDto findById(Long boardId){
        return boardMapper.selectById(boardId)
                .orElseThrow(() -> new IllegalStateException("유효하지 않은 게시물 번호"));
    }

    public List<BoardListDto> findAll(){
        return boardMapper.selectAll();
    }
}
