package com.example.ex02.controller;

import com.example.ex02.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class ProductController {

    @GetMapping("/product")
    public void product(){

    }

    @PostMapping("/product")
    public String product(ProductDto productDto, Model model){
        System.out.println("productDto = " + productDto);
        model.addAttribute("productDto", productDto);

        return "task/result2";
    }
}
