package com.zstu.tbmg.mapper.db2;

import com.zstu.tbmg.dto.ProductCategoryWithChildren;
import com.zstu.tbmg.pojo.ProductCategory;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface ProductCategoryMapper {

    @Select("select * from product_category")
    @Results(id = "productCategoryWithChildrenMap",value = {
            @Result(id = true, column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_code", property = "categoryCode"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "category_level", property = "categoryLevel"),
            @Result(column = "category_status", property = "categoryStatus"),
            @Result(column = "modified_time", property = "modifiedTime"),
            @Result(property = "children",column = "category_id",many = @Many(select = "selectChildren",
                                       fetchType = FetchType.EAGER))
    })
    List<ProductCategoryWithChildren> selectAllWithChildren();

    @Select("select * from product_category where parent_id=#{categoryId}")
    @Results(id = "productCategoryMap",value = {
            @Result(id = true, column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_code", property = "categoryCode"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "category_level", property = "categoryLevel"),
            @Result(column = "category_status", property = "categoryStatus"),
            @Result(column = "modified_time", property = "modifiedTime"),
    })
    List<ProductCategory> selectChildren(@Param("categoryId") Integer categoryId);
}