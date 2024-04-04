package com.example.ex04.dependency2;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class Printer {

    private final Ink ink;

    public Printer(@Qualifier("redInk") Ink ink) {
        this.ink = ink;
    }

    public void print(){
        ink.myColor();
    }
}
