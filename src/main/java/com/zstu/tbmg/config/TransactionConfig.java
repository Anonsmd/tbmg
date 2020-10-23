package com.zstu.tbmg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

//@Configuration
//@ComponentScan
public class TransactionConfig implements TransactionManagementConfigurer {
//public class TransactionConfig {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private DataSource dataSource2;

    @Bean(name = "transactionManager")
    @Primary
    @Override
    public DataSourceTransactionManager  annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "transactionManager2")
 //   @Override
    public DataSourceTransactionManager  annotationDrivenTransactionManager2() {
        return new DataSourceTransactionManager(dataSource2);
    }

}