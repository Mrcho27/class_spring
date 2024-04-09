package com.example.mybatis2.controller;

import com.example.mybatis2.dto.BoardDto;
import com.example.mybatis2.dto.SearchDto;
import com.example.mybatis2.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardMapper boardMapper;

    @GetMapping("/list")
    public String boardList(SearchDto searchDto, Model model){
        System.out.println("searchDto = " + searchDto);


        List<BoardDto> boardList = boardMapper.selectByKeyword(searchDto);
        model.addAttribute("boardList",boardList);

        return "board/list";
    }
}
