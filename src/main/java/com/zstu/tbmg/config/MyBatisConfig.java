package com.zstu.tbmg.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.sql.DataSource;

//@Configuration
//@ComponentScan
public class MyBatisConfig {
    @Resource(name = "dataSource")
    private DataSource dataSource;
    @Resource(name = "dataSource2")
    private DataSource dataSource2;

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
        return sessionFactory;
    }

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactoryBean sqlSessionFactory2(ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource2);
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath*:mapper2/*.xml"));
        return sessionFactory;
    }
}
