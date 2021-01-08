package com.zstu.tbmg.service;

import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.CustomerListDTO;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/8 14:19
 */
public interface CustomerService {
    CustomerListDTO getList(int pageNum, int pageSize, String customerName);

    boolean updateStatus(List<Integer> ids) throws Exception;
}
