package com.zstu.tbmg.mapper.db2;

import com.zstu.tbmg.pojo.ProductBrandInfo;
import com.zstu.tbmg.pojo.ProductNewRecommend;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductNewRecommendMapper {


    @Select("select * from product_new_recommend limit #{startNum},#{pageSize}")
    @Results(id = "productNewRecommendMap",value = {
            @Result(id = true, column = "new_recommend_id", property = "newRecommendId"),
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "pic_url", property = "picUrl"),
            @Result(column = "recommend_status", property = "recommendStatus"),
            @Result(column = "new_status", property = "newStatus"),
            @Result(column = "recommend_order", property = "recommendOrder"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    List<ProductNewRecommend> selectByPage(@Param("startNum") Integer startNum, @Param("pageSize") Integer pageSize);

    @Select("select * from product_new_recommend where product_new_recommend.product_name like #{productName}")
    @ResultMap("productNewRecommendMap")
    List<ProductNewRecommend> selectAll(@Param("productName") String productName);

    @Select("select count(*) as total from product_brand_info")
    Integer getTotal();

    @Update("update product_new_recommend set recommend_order = #{recommendOrder} where new_recommend_id = #{newRecommendId}")
    void updatenewRecommendOrder(@Param("recommendOrder")Byte recommendOrder,@Param("newRecommendId")Integer newRecommendId);

    @Update("update product_new_recommend set recommend_status = if(recommend_status=0,1,0) where new_recommend_id = #{newRecommendId}")
    void updateRecommendStatus(@Param("newRecommendId")Integer newRecommendId);
}