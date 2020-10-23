package com.zstu.tbmg.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.zstu.tbmg.mapper.db2"}, sqlSessionTemplateRef = "sqlSessionTemplateTwo")
public class SqlSessionTemplateTwoConfig {

    @Value("${mybatis.mapper-locations2}")
    private String mapper_location;

    @Bean
    public SqlSessionFactory sqlSessionFactoryTwo(@Qualifier("dataSourceTwo") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //如果重写了 SqlSessionFactory 需要在初始化的时候手动将 mapper 地址 set到 factory 中，否则会报错：
        //org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_location));
        return bean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateTwo(@Qualifier("sqlSessionFactoryTwo") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }
}