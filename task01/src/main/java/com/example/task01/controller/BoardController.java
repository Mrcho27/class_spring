package com.example.task01.controller;

import com.example.task01.dto.BoardDto;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("list")
    public void boardList(){}

    @GetMapping("/detail")
    public void boardDetail(){}

    @GetMapping("/write")
    public String boardWrite(HttpSession session){
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null){
            return "user/login";
        }

        return "board/write";
    }

    @PostMapping("/write")
    public void boardWrite(BoardDto boardDto){
        log.info("boardDto = {}", boardDto);

    }
}
