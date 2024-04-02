package com.example.ex02.controller;

import com.example.ex02.dto.BoardDto;
import com.example.ex02.dto.TaskDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/task")
public class TaskController {
    @GetMapping("/favorite")
    public void favorite(){
}

    @PostMapping("/favorite")
    public String favorite(TaskDto taskDto, Model model) {
        System.out.println("taskDto = " + taskDto + ", model = " + model);
        model.addAttribute("taskDto",taskDto);

        return "task/result1";
    }

    @GetMapping("/write")
    public void write(){

    }

    @PostMapping("/write")
    public String write(BoardDto boardDto, Model model){
        System.out.println("boardDto = " + boardDto + ", model = " + model);
        model.addAttribute("boardDto",boardDto);


            return "task/view";

    }
}
