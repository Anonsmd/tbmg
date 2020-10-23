package com.zstu.tbmg.config;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: Anonsmd
 * @Date: 2020/10/23 16:18
 */
@Configuration
//下面的sqlSessionTemplateRef 值需要和生成的SqlSessionTemplate bean name相同，如果没有指定name,那么就是方法名
@MapperScan(basePackages = {"com.zstu.tbmg.mapper.db1"}, sqlSessionTemplateRef = "sqlSessionTemplateOne")
public class DataSourceOneConfig {

    @Value("${mybatis.mapper-locations1}")
    private String mapper_location;

    @Value("${mybatis.config-location}")
    private String mybatis_config;

    private Logger logger = LoggerFactory.getLogger(DataSourceOneConfig.class);

    @Primary
    @Bean(name = "datasourceOne")
    @ConfigurationProperties(prefix = "spring.datasource.druid.one")
    public DataSource datasourceOne() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("datasourceOne") DataSource dataSource) throws Exception {
        logger.info("mapper文件地址：" + mapper_location);
        logger.info("mybatis配置文件地址：" + mybatis_config);
        //在基本的 MyBatis 中,session 工厂可以使用 SqlSessionFactoryBuilder 来创建。
        // 而在 MyBatis-spring 中,则使用SqlSessionFactoryBean 来替代：
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //如果重写了 SqlSessionFactory 需要在初始化的时候手动将 mapper 地址 set到 factory 中，否则会报错：
        //org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapper_location));
//        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(mybatis_config));
        return bean.getObject();
    }

    /**
     * SqlSessionTemplate 是 SqlSession接口的实现类，是spring-mybatis中的，实现了SqlSession线程安全
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplateOne(@Qualifier("sqlSessionFactoryOne") SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }
    /**
     * 为选中的数据源 datasourceOne 添加事务管理
     * @param dataSource
     * @return transactionManagerOne service层@Transactional(value引用的就是这里的值)
     */
    @Bean
    public DataSourceTransactionManager transactionManagerOne(@Qualifier("datasourceOne") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
