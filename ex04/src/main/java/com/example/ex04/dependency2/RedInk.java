package com.example.ex04.dependency2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("redInk")
public class RedInk implements Ink{
    public void myColor(){
        System.out.println("=======RED========");
    }
}
