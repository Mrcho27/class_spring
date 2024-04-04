package com.example.ex04.dependency2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("blackInk")@Primary
public class BlackInk implements Ink{
    public void myColor(){
        System.out.println("*****Black*****");
    }
}
