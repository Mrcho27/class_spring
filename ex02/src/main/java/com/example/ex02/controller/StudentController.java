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

//    @PostMapping("/student")
//    public String student(StudentDto studentDto, Model model){
//        System.out.println("studentDto = " + studentDto);
//        int total = studentDto.getEng() + studentDto.getKor() + studentDto.getMath();
//        double avg = total / 3.0;
//
//        model.addAttribute("studentDto", studentDto);
//        model.addAttribute("total", total);
//        model.addAttribute("avg", avg);
//        return "task/result2";
//    }


}
