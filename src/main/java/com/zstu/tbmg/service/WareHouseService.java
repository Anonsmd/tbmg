package com.zstu.tbmg.service;

import com.zstu.tbmg.pojo.WareHouseInfo;
import com.zstu.tbmg.pojo.WareHouseProduct;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 15:20
 */
public interface WareHouseService {
    List<WareHouseInfo> getInfoList() throws Exception;

    boolean createOrUpdate(WareHouseProduct wareHouseProduct) throws Exception;
}
