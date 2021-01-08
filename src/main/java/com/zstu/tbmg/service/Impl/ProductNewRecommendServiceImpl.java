package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.ProductNewRecommendOrderDTO;
import com.zstu.tbmg.dto.ProductNewRecommmendList;
import com.zstu.tbmg.mapper.db2.ProductNewRecommendMapper;
import com.zstu.tbmg.pojo.ProductBrandInfo;
import com.zstu.tbmg.pojo.ProductNewRecommend;
import com.zstu.tbmg.service.ProductNewRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 18:12
 */
@Service
public class ProductNewRecommendServiceImpl implements ProductNewRecommendService {
    @Autowired
    private ProductNewRecommendMapper productNewRecommendMapper;

    @Override
    public ProductNewRecommmendList getList(int pageNum, int pageSize, String productName, Byte recommendStatus) throws Exception {
        if (productName == null){
            productName="%%";
        }
        else{
            productName='%'+productName+'%';
        }
        List<ProductNewRecommend> productNewRecommendListBefore = productNewRecommendMapper.selectAll(productName);
        List<ProductNewRecommend>  productNewRecommendListAfter= new ArrayList<>();
        boolean flag = true;
        for (int i = 0;i<productNewRecommendListBefore.size();i++){
            flag = true;
            if (recommendStatus != null && !productNewRecommendListBefore.get(i).getRecommendStatus().equals(recommendStatus)){
                flag = false;
            }
            if (flag){
                productNewRecommendListAfter.add(productNewRecommendListBefore.get(i));
            }
        }
        int total = productNewRecommendListAfter.size();
        List<ProductNewRecommend> answList = new ArrayList<>();
        ProductNewRecommmendList answ = new ProductNewRecommmendList();
        if (total<=pageSize){
            answ.setList(productNewRecommendListAfter);
        }
        else{
            if ((pageNum-1)*pageSize+pageSize<total){
                answ.setList(productNewRecommendListAfter.subList((pageNum - 1) * pageSize, (pageNum - 1) * pageSize + pageSize));
            }
            else{
                answ.setList(productNewRecommendListAfter.subList((pageNum - 1) * pageSize,total));
            }
        }
        answ.setPageNum(pageNum);
        answ.setPageSize(pageSize);
        answ.setTotal(total);
        answ.setTotalPage((total+pageSize-1)/pageSize);
        return answ;
    }

    @Override
    @Transactional
    public boolean setOrder(ProductNewRecommendOrderDTO productNewRecommendOrderDTO) throws Exception {
        productNewRecommendMapper.updatenewRecommendOrder(productNewRecommendOrderDTO.getProductOrder(),productNewRecommendOrderDTO.getNewRecommendId());
        return true;
    }

    @Override
    @Transactional
    public boolean updateRecommendSatus(List<Integer> ids) throws Exception {
        for (int i=0;i<ids.size();i++){
            productNewRecommendMapper.updateRecommendStatus(ids.get(i));
        }
        return true;
    }
}
