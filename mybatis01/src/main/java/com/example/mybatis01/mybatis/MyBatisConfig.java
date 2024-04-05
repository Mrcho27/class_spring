package com.example.mybatis01.mybatis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// 스프링 컨테이너에 빈을 등록할 때 사용하는 어노테이션은 @Component이다.
// 스프링 컨테이너에 빈을 등록하는 어노테이션이 하나만 있는게 아니다.
// 여러 가지가 존재하는데 그 중 하나가 @Configuration이다.
// @Configuration은 설정을 위한 빈이라고 알려주며 등록하는 것이다.
@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final ApplicationContext applicationContext; //스프링 컨테이너 구현체

//    이 어노테이션은 외부파일의 설정 값들을 자바 객체로 가져올 때 사용한다.
//    스프링부트에서는 application.properties라는 파일에 설정 값을 작성하기 때문에
//    해당파일에서 특정 속성을 가져올 때 사용하는 어노테이션이다.
//    접두사를 설정하여 "spring.datasource.hikari"로 시작하는 모든 설정값을 가져오라는 의미이다.
    @Bean // 외부 라이브러리 객체는 우리가 직접 @Component 어노테이션을 달 수 없다.
//    그래서 @Configuration 어노테이션이 달린 클래스에 메소드의 반환객체로 설정하고
//    해당 메소드에 @Bean 어노테이션을 달아서 반환되는 객체를 빈등록해준다.
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){
//        Hikari란?
//        HikariCP(히카리 커넥션 풀)라이브러리를 의미한다.
//        빠르고, 가볍고, 설정이 쉽고, 안정성이 높다는 장점이 있다.
//        Servlet/JSP 에서는 아파치 톰캣에서 지원하는 DBCP를 사용하였으나
//        Spring에서는 Hikari를 사용한다.
        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource(){
//        DataSource란?
//        DataSource객체는 CP(커넥션 풀)을 관리하고 CP에 있는 커넥션 객체를 제공/반납받는 동의 일을 한다.
//        모든 CP 라이브러리는 DataSource객체를 사용한다.
//        이 객체가 데이터베이스 커넥션을 관리, 풀을 통한 재사용을 담당하며 CP을 사용하려면 항상 DataSource객체가 필요하다.
//        DataSource객체를 만들기 위해서는 DB정보가 필요하다.
//        해당 정보는 위에서 만든 HikariConfig객체가 가지고 있다.
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        Spring에서는 SqlSessionFactory객체도 Bean으로 만들어 스프링 컨테이너가 관리하도록 해야한다.
//        SqlSessionFactoryBean 객체에 설정을 해주면 팩토리를 지어주는 SqlSessionFactoryBuilder의 역할을 수행하며
//        그렇게 만들어진 SqlSessionFactory를 스프링 컨테이너가 관리한다.
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

//        매퍼 파일 경로를 알려주기 위한 설정
//        applicationContext 객체는 현재 프로젝트의 설정, 파일 경로 등을 알고 있다.
//        classpath*는 java 디렉터리와 resource디렉터리에서 검색하여 일치하는 모든 파일을 찾아낸다.(여러파일)
//        해당 패턴으로 검색된 파일들의 경로를 sqlSessionFactoryBean에 저장한다.
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/**/*.xml"));

//        config.xml의 경로를 알려준다.
//        classpath는 하나의 파일만 검색하여 찾는다.
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/config.xml"));

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }
}
