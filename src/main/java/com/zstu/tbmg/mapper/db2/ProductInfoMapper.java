package com.zstu.tbmg.mapper.db2;

import com.zstu.tbmg.pojo.ManagerLogin;
import com.zstu.tbmg.pojo.ProductInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductInfoMapper {
    @Select("select product_info.*,product_pic_info.pic_url,warehouse_product.sell_cnt,warehouse_product.current_cnt,warehouse_info.warehouse_name " +
            "from product_info left join product_pic_info on " +
            "product_info.product_id = product_pic_info.product_id " +
            "and product_pic_info.is_master=1 " +
            "left join warehouse_product on product_info.product_id = warehouse_product.product_id " +
            "left join warehouse_info on warehouse_product.warehouse_id = warehouse_info.warehouse_id " +
            "where product_info.product_name like #{keyword} OR product_info.descript like #{keyword} " +
            "limit #{startNum},#{pageSize}")
    @Results(id = "productInfoWithPicMap", value={
            @Result(id = true, column = "product_id", property = "productId"),
            @Result(column = "product_core", property = "productCore"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "bar_code", property = "barCode"),
            @Result(column = "brand_id", property = "brandId"),
            @Result(column = "one_category_id", property = "oneCategoryId"),
            @Result(column = "two_category_id", property = "twoCategoryId"),
            @Result(column = "three_category_id", property = "threeCategoryId"),
            @Result(column = "supplier_id", property = "supplierId"),
            @Result(column = "price", property = "price"),
            @Result(column = "average_cost", property = "averageCost"),
            @Result(column = "publish_status", property = "publishStatus"),
            @Result(column = "audit_status", property = "auditStatus"),
            @Result(column = "weight", property = "weight"),
            @Result(column = "length", property = "length"),
            @Result(column = "height", property = "height"),
            @Result(column = "width", property = "width"),
            @Result(column = "color", property = "color"),
            @Result(column = "production_date", property = "productionDate"),
            @Result(column = "shelf_life", property = "shelfLife"),
            @Result(column = "descript", property = "descript"),
            @Result(column = "indate", property = "indate"),
            @Result(column = "modified_time", property = "modifiedTime"),
            @Result(column = "pic_url", property = "pic"),
            @Result(column = "sell_cnt", property = "sellNum"),
            @Result(column = "current_cnt", property = "stockNum"),
            @Result(column = "warehouse_name", property = "wareHouse")
    })
    List<ProductInfo> selectByPage(@Param("startNum") Integer startNum,@Param("pageSize") Integer pageSize,@Param("keyword") String keyword);

    @Select("select product_info.*,product_pic_info.pic_url,warehouse_product.sell_cnt,warehouse_product.current_cnt,warehouse_info.warehouse_name " +
            "from product_info left join product_pic_info on " +
            "product_info.product_id = product_pic_info.product_id " +
            "and product_pic_info.is_master=1 " +
            "left join warehouse_product on product_info.product_id = warehouse_product.product_id " +
            "left join warehouse_info on warehouse_product.warehouse_id = warehouse_info.warehouse_id " +
            "where product_info.product_name like #{keyword} OR product_info.descript like #{keyword}")
    @ResultMap("productInfoWithPicMap")
    List<ProductInfo> selectAll(@Param("keyword") String keyword);

    @Select("select product_info.*,product_pic_info.pic_url,warehouse_product.sell_cnt,warehouse_product.current_cnt,warehouse_info.warehouse_name " +
            "from product_info left join product_pic_info on " +
            "product_info.product_id = product_pic_info.product_id " +
            "and product_pic_info.is_master=1 " +
            "left join warehouse_product on product_info.product_id = warehouse_product.product_id " +
            "left join warehouse_info on warehouse_product.warehouse_id = warehouse_info.warehouse_id " +
            "where product_info.product_id = #{productId}")
    @ResultMap("productInfoWithPicMap")
    ProductInfo selectByProductId(@Param("productId") Integer productId);

    @Select("select count(*) as total from product_info")
    Integer getTotal();

    @Update("update product_info set publish_status=if(publish_status=0,1,0) where product_id = #{productId};")
    void updatePublishStatus(@Param("productId") Integer productId);

    @Update("update product_info set audit_status=if(audit_status=0,1,0) where product_id = #{productId};")
    void updateAuditStatus(@Param("productId") Integer productId);
}