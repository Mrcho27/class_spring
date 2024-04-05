package com.example.ex04.dependency3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
ZooKeeper(사육사), Sheep, Tiger, Animal을 활용하여
의존관계를 맺는다.
모든 동물은 crying() 메서드를 가진다.
 */
@Component
public class ZooKeeper {

    private final Animal animal;

    @Autowired
    public ZooKeeper(@Qualifier("tiger") Animal animal) {
        this.animal = animal;
    }
    
    public void whipping(){
        System.out.println("찰싹");
        animal.crying();
    }



}
