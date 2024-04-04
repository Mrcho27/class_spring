package com.example.ex04.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public int ageProcess(int age){
        return age-2;
    }
}
