package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.mapper.db2.WareHouseInfoMapper;
import com.zstu.tbmg.pojo.WareHouseInfo;
import com.zstu.tbmg.pojo.WareHouseProduct;
import com.zstu.tbmg.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 15:21
 */
@Service
public class WareHouseServiceImpl implements WareHouseService {
    @Autowired
    private WareHouseInfoMapper wareHouseInfoMapper;

    @Override
    public List<WareHouseInfo> getInfoList() throws Exception {
        return wareHouseInfoMapper.selectAll();
    }

    @Override
    @Transactional
    public boolean createOrUpdate(WareHouseProduct wareHouseProduct) throws Exception {
        if (wareHouseProduct.getProductId() != null && wareHouseProduct.getProductId() >0){
            wareHouseInfoMapper.updateAll(wareHouseProduct);
        }
        else{
            wareHouseInfoMapper.insertAll(wareHouseProduct);
        }
        return true;
    }
}
