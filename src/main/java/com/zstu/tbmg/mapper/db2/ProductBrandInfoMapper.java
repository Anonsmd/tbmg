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
            @Result(column = "modified_time", property = "modifiedTime"),
            @Result(column = "recommend_status", property = "recommendStatus")
    })
    List<ProductBrandInfo> selectByPage(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);

    @Select("select * from product_brand_info where product_brand_info.brand_name like #{brandName}")
    @ResultMap("brandInfoMap")
    List<ProductBrandInfo> selectAll(@Param("brandName") String brandName);

    @Select("select count(*) as total from product_brand_info")
    Integer getTotal();

    @Update("update product_brand_info set brand_order = #{brandOrder} where brand_id = #{brandId}")
    void updateBrandOrder(@Param("brandOrder")Byte brandOrder,@Param("brandId")Integer brandId);

    @Update("update product_brand_info set recommend_status = if(recommend_status=0,1,0) where brand_id = #{brandId}")
    void updateRecommendStatus(@Param("brandId")Integer brandId);
}