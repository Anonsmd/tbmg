package com.zstu.tbmg.service;

import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.BrandOrderDTO;
import com.zstu.tbmg.dto.ProductNewRecommendOrderDTO;
import com.zstu.tbmg.dto.ProductNewRecommmendList;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 18:09
 */
public interface ProductNewRecommendService {
    ProductNewRecommmendList getList(int pageNum, int pageSize, String productName, Byte recommendStatus) throws Exception;

    boolean setOrder(ProductNewRecommendOrderDTO productNewRecommendOrderDTO) throws Exception;

    boolean updateRecommendSatus(List<Integer> ids) throws Exception;
}
