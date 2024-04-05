package com.example.mybatis01.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MyBatisConfigTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Test
    void dataSourceTest(){
//        try-with-resources 문법
//        기존에 우리가 자원을 가져와 사용하면 다 쓴 자원은 닫아줘야하는데
//        이 문법에서 try의 ()안에서 생성한 자원은 자동으로 close 해준다.
        try(Connection connection = dataSource.getConnection()){
            System.out.println("connection = " + connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void sqlSessionTest(){
        try(
                SqlSession sqlSession = sqlSessionFactory.openSession(true);
                Connection connection = sqlSession.getConnection();
        ){
            System.out.println("sqlSession = " + sqlSession);
            System.out.println("connection = " + connection);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}