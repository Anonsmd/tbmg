package com.zstu.tbmg.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyBatisScannerConfig {
    @Bean
    @Primary
   public MapperScannerConfigurer MapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.zstu.tbmg.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return mapperScannerConfigurer;
    }

//    @Bean
//    public MapperScannerConfigurer MapperScannerConfigurer2() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("com.zstu.tbmg.mapper2");
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory2");
//        return mapperScannerConfigurer;
//    }
}
