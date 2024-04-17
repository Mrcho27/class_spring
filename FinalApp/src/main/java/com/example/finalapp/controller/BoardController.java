package com.example.finalapp.controller;

import com.example.finalapp.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String boardList(){
        return "board/list";
    }

    @GetMapping("/write")
    public String boardWrite(){
        return "board/write";
    }

    @GetMapping("/view")
    public String boardView(){
        return "board/view";
    }
}
