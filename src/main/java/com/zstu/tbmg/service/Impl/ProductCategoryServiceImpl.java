package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.ProductCategoryWithChildren;
import com.zstu.tbmg.mapper.db2.ProductCategoryMapper;
import com.zstu.tbmg.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 15:55
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public List<ProductCategoryWithChildren> getListWithChildren() throws Exception{
        return productCategoryMapper.selectAllWithChildren();
    }
}
