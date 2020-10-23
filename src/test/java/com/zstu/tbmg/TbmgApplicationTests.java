package com.zstu.tbmg;

import com.zstu.tbmg.mapper.db1.UserMapper;
import com.zstu.tbmg.mapper.db2.CustomerLoginMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest()
class TbmgApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomerLoginMapper customerLoginMapper;
    
    @Test
    void contextLoads() {
        System.out.println(userMapper.selectByPrimaryKey("18e36cd7-053c-49e8-bb60-516600cabc40"));
        System.out.println(customerLoginMapper.selectByPrimaryKey(1));
    }

    @Test
    @Transactional
    void contextLoads2() {
        System.out.println(userMapper.selectByPrimaryKey("18e36cd7-053c-49e8-bb60-516600cabc40"));
        System.out.println(customerLoginMapper.selectByPrimaryKey(1));
        customerLoginMapper.deleteByPrimaryKey(1);
        System.out.println(10/0);
    }

}
