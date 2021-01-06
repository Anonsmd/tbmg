package com.zstu.tbmg.service;

import com.zstu.tbmg.dto.ProductCategoryWithChildren;
import com.zstu.tbmg.dto.ProductListDTO;
import com.zstu.tbmg.pojo.ProductCategory;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 15:54
 */
public interface ProductCategoryService {
    List<ProductCategoryWithChildren> getListWithChildren() throws Exception;
}
