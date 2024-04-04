package com.example.ex04.dependency3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ZooKeeperTest {
    @Autowired
    ZooKeeper zooKeeper;

    @Test
    void whippingTest(){
        zooKeeper.whipping();
    }
}