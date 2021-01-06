package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.ProductListDTO;
import com.zstu.tbmg.mapper.db2.ProductBrandInfoMapper;
import com.zstu.tbmg.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 14:46
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private ProductBrandInfoMapper productBrandInfoMapper;

    @Override
    public BrandListDTO getList(int pageNum, int pageSize) throws Exception{
        int total = productBrandInfoMapper.getTotal();
        BrandListDTO answ = new BrandListDTO();
        answ.setPageNum(pageNum);
        answ.setPageSize(pageSize);
        answ.setTotal(total);
        answ.setTotalPage((total+pageSize-1)/pageSize);
        answ.setList(productBrandInfoMapper.selectByPage((pageNum-1)*pageSize,pageSize));
        return answ;
    }
}
