package com.example.ex02.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String name;
    private int math;
    private int eng;
    private int kor;

//    public int getTotal(){
//        return math + eng + kor;
//    }
//
//    public double getAvg(){
//        return getTotal()/3.0;
//    }
}


