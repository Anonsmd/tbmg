package com.zstu.tbmg.mapper.db2;

import com.zstu.tbmg.pojo.ProductBrandInfo;
import com.zstu.tbmg.pojo.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductBrandInfoMapper {


    @Select("select * from product_brand_info limit #{startNum},#{pageSize}")
    @Results(id = "brandInfoMap",value = {
            @Result(id = true, column = "brand_id", property = "brandId"),
            @Result(column = "brand_name", property = "brandName"),
            @Result(column = "telephone", property = "telephone"),
            @Result(column = "brand_web", property = "brandWeb"),
            @Result(column = "brand_logo", property = "brandLogo"),
            @Result(column = "brand_desc", property = "brandDesc"),
            @Result(column = "brand_status", property = "brandStatus"),
            @Result(column = "brand_order", property = "brandOrder"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    List<ProductBrandInfo> selectByPage(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);

    @Select("select * from product_brand_info")
    @ResultMap("brandInfoMap")
    List<ProductInfo> selectAll();

    @Select("select count(*) as total from product_brand_info")
    Integer getTotal();
}