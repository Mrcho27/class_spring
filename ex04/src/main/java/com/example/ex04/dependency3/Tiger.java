package com.example.ex04.dependency3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tiger")
public class Tiger implements Animal{

    @Override
    public void crying() {
        System.out.println("어흥");
    }
}
