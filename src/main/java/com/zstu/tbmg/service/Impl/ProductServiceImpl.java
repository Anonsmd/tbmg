package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.ProductListDTO;
import com.zstu.tbmg.mapper.db2.ProductInfoMapper;
import com.zstu.tbmg.mapper.db2.ProductSupplierInfoMapper;
import com.zstu.tbmg.pojo.ProductInfo;
import com.zstu.tbmg.pojo.ProductSupplierInfo;
import com.zstu.tbmg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 13:03
 */

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Autowired
    private ProductSupplierInfoMapper productSupplierInfoMapper;
    @Override
    public boolean updatePublishStatus(List<Integer> ids) throws Exception {
        for (int i=0;i<ids.size();i++){
            productInfoMapper.updatePublishStatus(ids.get(i));
        }
        return true;
    }

    @Override
    public boolean updateVerifyStatus(List<Integer> ids) throws Exception {
        for (int i=0;i<ids.size();i++){
            productInfoMapper.updateAuditStatus(ids.get(i));
        }
        return true;
    }

    @Override
    public ProductListDTO getList(Integer pageNum, Integer pageSize,
                                  String keyword,
                                  Byte publishStatus, Byte verifyStatus,
                                  String productSn,
                                  Integer productCategory, Integer brandId) throws Exception {
        if (keyword == null){
            keyword="%%";
        }
        else{
            keyword='%'+keyword+'%';
        }
        List<ProductInfo> productInfoListBefore = productInfoMapper.selectAll(keyword);
        List<ProductInfo> productInfoListAfter = new ArrayList<>();
        boolean flag = true;
        for (int i = 0;i<productInfoListBefore.size();i++){
            flag = true;
            if (publishStatus != null && !productInfoListBefore.get(i).getPublishStatus().equals(publishStatus)){
                flag = false;
            }
            if (verifyStatus != null && !productInfoListBefore.get(i).getAuditStatus().equals(verifyStatus)){
                flag = false;
            }
            if (productSn != null && productSn.length()>0 && !productInfoListBefore.get(i).getProductCore().equals(productSn)){
                flag = false;
            }
            if (productCategory != null &&(
                    !productInfoListBefore.get(i).getOneCategoryId().equals(productCategory) &&
                    !productInfoListBefore.get(i).getTwoCategoryId().equals(productCategory) &&
                    !productInfoListBefore.get(i).getThreeCategoryId().equals(productCategory))){
                flag = false;
            }
            if (brandId != null && !productInfoListBefore.get(i).getBrandId().equals(brandId)){
                flag = false;
            }
            if (flag){
                productInfoListAfter.add(productInfoListBefore.get(i));
            }
        }
        int total = productInfoListAfter.size();
        List<ProductInfo> answList = new ArrayList<>();
        ProductListDTO answ = new ProductListDTO();
        if (total<=pageSize){
            answ.setList(productInfoListAfter);
        }
        else{
            if ((pageNum-1)*pageSize+pageSize<total){
                answ.setList(productInfoListAfter.subList((pageNum - 1) * pageSize, (pageNum - 1) * pageSize + pageSize));
            }
            else{
                answ.setList(productInfoListAfter.subList((pageNum - 1) * pageSize,total));
            }
        }
        answ.setPageNum(pageNum);
        answ.setPageSize(pageSize);
        answ.setTotal(total);
        answ.setTotalPage((total+pageSize-1)/pageSize);
        return answ;
    }

    @Override
    public ProductInfo getProduct(Integer productId) throws Exception {
        return productInfoMapper.selectByProductId(productId);
    }

    @Override
    public List<ProductSupplierInfo> getSupplier() throws Exception {
        return productSupplierInfoMapper.selectAll();
    }

    @Override
    @Transactional
    public Integer createOrUpdate(ProductInfo productInfo) throws Exception {
        if (productInfo.getProductId() != null && productInfo.getProductId() >0){
            productInfoMapper.updateAll(productInfo);
            return productInfo.getProductId();
        }
        else{
            productInfoMapper.insertAll(productInfo);
            return  productInfoMapper.getAutoIncrement();
        }
    }
}
