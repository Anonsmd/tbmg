package com.zstu.tbmg;

import com.zstu.tbmg.mapper.db2.OrderDetailMapper;
import com.zstu.tbmg.mapper.db2.ProductCategoryMapper;
import com.zstu.tbmg.mapper.db2.ProductInfoMapper;
import com.zstu.tbmg.pojo.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest()
class TbmgApplicationTests {

    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Test
    void contextLoads() {
        System.out.println("------------------------------------------------------------------------------");
//        System.out.println(productInfoMapper.selectByPage(0,5));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println(productInfoMapper.getTotal());
    }

    @Test
    void testForCategoryWithChildren(){
//        System.out.println(orderDetailMapper.selectByPrimaryKey(1));
//        System.out.println(orderDetailMapper.getTotal());
    }
//    @Test
//    @Transactional
//    void contextLoads2() {
//        System.out.println(userMapper.selectByPrimaryKey("18e36cd7-053c-49e8-bb60-516600cabc40"));
//        System.out.println(customerLoginMapper.selectByPrimaryKey(1));
//        customerLoginMapper.deleteByPrimaryKey(1);
//        System.out.println(10/0);
//    }

}
