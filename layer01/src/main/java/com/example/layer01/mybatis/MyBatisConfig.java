package com.example.layer01.mybatis;

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


@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final ApplicationContext applicationContext; //스프링 컨테이너 구현체


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig(){

        return new HikariConfig();
    }

    @Bean
    public DataSource dataSource(){

        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());


        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:/mapper/**/*.xml"));


        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:/config/config.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.layer01.dto");

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }
}
