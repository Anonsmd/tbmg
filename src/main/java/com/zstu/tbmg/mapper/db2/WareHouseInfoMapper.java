package com.zstu.tbmg.mapper.db2;

import com.zstu.tbmg.pojo.WareHouseInfo;
import com.zstu.tbmg.pojo.WareHouseProduct;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WareHouseInfoMapper {

    @Select("select * from warehouse_info")
    @Results(id = "wareHouseInfoMap",value = {
            @Result(id = true,column = "warehouse_id",property = "warehouseId"),
            @Result(column = "warehouse_sn",property = "warehouseSn"),
            @Result(column = "warehouse_name",property = "warehouseName"),
            @Result(column = "warehouse_phone",property = "warehousePhone"),
            @Result(column = "contact",property = "contact"),
            @Result(column = "province",property = "province"),
            @Result(column = "city",property = "city"),
            @Result(column = "distrct",property = "distrct"),
            @Result(column = "address",property = "address"),
            @Result(column = "warehouse_status",property = "warehouseStatus"),
            @Result(column = "modified_time",property = "modifiedTime")
    })
    List<WareHouseInfo> selectAll();

//    @Insert("insert into warehouse_product(product_id,warehouse_id,current_cnt,sell_cnt,average_cost)")
    void insertAll(WareHouseProduct wareHouseProduct);


    void updateAll(WareHouseProduct wareHouseProduct);
}