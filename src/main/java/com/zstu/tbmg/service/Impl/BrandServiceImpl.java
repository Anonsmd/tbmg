package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.BrandOrderDTO;
import com.zstu.tbmg.dto.ProductListDTO;
import com.zstu.tbmg.mapper.db2.ProductBrandInfoMapper;
import com.zstu.tbmg.pojo.ProductBrandInfo;
import com.zstu.tbmg.pojo.ProductInfo;
import com.zstu.tbmg.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 14:46
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private ProductBrandInfoMapper productBrandInfoMapper;

    @Override
    public BrandListDTO getList(int pageNum, int pageSize,String brandName,Byte recommendStatus) throws Exception{
        if (brandName == null){
            brandName="%%";
        }
        else{
            brandName='%'+brandName+'%';
        }
        List<ProductBrandInfo> brandInfoListBefore = productBrandInfoMapper.selectAll(brandName);
        List<ProductBrandInfo>  brandInfoListAfter= new ArrayList<>();
        boolean flag = true;
        for (int i = 0;i<brandInfoListBefore.size();i++){
            flag = true;
            if (recommendStatus != null && !brandInfoListBefore.get(i).getRecommendStatus().equals(recommendStatus)){
                flag = false;
            }
            if (flag){
                brandInfoListAfter.add(brandInfoListBefore.get(i));
            }
        }
        int total = brandInfoListAfter.size();
        List<ProductBrandInfo> answList = new ArrayList<>();
        BrandListDTO answ = new BrandListDTO();
        if (total<=pageSize){
            answ.setList(brandInfoListAfter);
        }
        else{
            if ((pageNum-1)*pageSize+pageSize<total){
                answ.setList(brandInfoListAfter.subList((pageNum - 1) * pageSize, (pageNum - 1) * pageSize + pageSize));
            }
            else{
                answ.setList(brandInfoListAfter.subList((pageNum - 1) * pageSize,total));
            }
        }
        answ.setPageNum(pageNum);
        answ.setPageSize(pageSize);
        answ.setTotal(total);
        answ.setTotalPage((total+pageSize-1)/pageSize);
        return answ;
    }

    @Override
    public boolean setOrder(BrandOrderDTO brandOrderDTO) throws Exception {
        productBrandInfoMapper.updateBrandOrder(brandOrderDTO.getBrandOrder(),brandOrderDTO.getBrandId());
        return true;
    }

    @Override
    public boolean updateRecommendSatus(List<Integer> ids) throws Exception {
        for (int i=0;i<ids.size();i++){
            productBrandInfoMapper.updateRecommendStatus(ids.get(i));
        }
        return true;
    }
}
