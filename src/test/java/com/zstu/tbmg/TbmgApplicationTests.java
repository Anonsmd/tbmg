package com.zstu.tbmg;

import com.zstu.tbmg.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class TbmgApplicationTests {

    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private CustomerLoginMapper customerLoginMapper;
    
    @Test
    void contextLoads() {
        System.out.println(userMapper.selectByPrimaryKey("18e36cd7-053c-49e8-bb60-516600cabc40"));
//        System.out.println(customerLoginMapper.selectByPrimaryKey(1));
    }

}
