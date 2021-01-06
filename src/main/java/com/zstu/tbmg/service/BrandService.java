package com.zstu.tbmg.service;

import com.zstu.tbmg.dto.BrandListDTO;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 14:46
 */
public interface BrandService {
    BrandListDTO getList(int pageNum, int pageSize) throws Exception;
}
