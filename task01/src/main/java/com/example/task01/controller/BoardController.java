package com.example.task01.controller;

import com.example.task01.dto.BoardDetailDto;
import com.example.task01.dto.BoardDto;
import com.example.task01.dto.BoardListDto;
import com.example.task01.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("list")
    public String boardList(Model model){
        List<BoardListDto> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);

        return "board/list";
    }

    @GetMapping("/detail")
    public String boardDetail(Long boardId,Model model){
        BoardDetailDto boardDto = boardService.findById(boardId);
        model.addAttribute("board", boardDto);
        return "board/detail";
    }

    @GetMapping("/write")
    public String boardWrite(HttpSession session){
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null){
            return "user/login";
        }

        return "board/write";
    }

    @PostMapping("/write")
    public String boardWrite(BoardDto boardDto,
                           HttpSession session,
                           @SessionAttribute("userId") Long userId){

//        Long userId = (Long) session.getAttribute("userId");
        boardDto.setUserId(userId);
        log.info("boardDto = {}", boardDto);
        boardService.registerBoard(boardDto);

        return "redirect:/board/list";
    }
}
