package com.example.ex02.controller;

import com.example.ex02.dto.StudentDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class StudentController {

    @GetMapping("/student")
    public void student(){}

    @PostMapping("/student")
    public String student(StudentDto studentDto, Model model){
        System.out.println("studentDto = " + studentDto);
        model.addAttribute("studentDto",studentDto);
        return "task/result3";
    }

}
