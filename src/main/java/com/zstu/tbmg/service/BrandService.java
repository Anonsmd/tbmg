package com.zstu.tbmg.service;

import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.BrandOrderDTO;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 14:46
 */
public interface BrandService {
    BrandListDTO getList(int pageNum, int pageSize,String brandName,Byte recommendStatus) throws Exception;

    boolean setOrder(BrandOrderDTO brandOrderDTO) throws Exception;

    boolean updateRecommendSatus(List<Integer> ids) throws Exception;
}
