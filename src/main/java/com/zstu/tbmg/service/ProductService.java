package com.zstu.tbmg.service;

import com.zstu.tbmg.dto.ProductListDTO;
import com.zstu.tbmg.pojo.ProductInfo;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 12:54
 */
public interface ProductService {
//    ProductListDTO getList(int pageNum, int pageSize) throws Exception;

    boolean updatePublishStatus(List<Integer> ids) throws Exception;;

    boolean updateVerifyStatus(List<Integer> ids) throws Exception;;

    ProductListDTO getList(Integer pageNum, Integer pageSize, String keyword, Byte publishStatus, Byte verifyStatus, String productSn, Integer productCategory, Integer brandId) throws Exception;;

    ProductInfo getProduct(Integer productId) throws Exception;
}
