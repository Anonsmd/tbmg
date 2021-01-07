package com.zstu.tbmg.mapper.db2;

import com.zstu.tbmg.pojo.ProductSupplierInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductSupplierInfoMapper {

    @Select("select * from product_supplier_info;")
    @Results(id = "productSupplierInfoMap",value = {
            @Result(id = true,column = "supplier_id",property = "supplierId"),
            @Result(column = "supplier_code",property = "supplierCode"),
            @Result(column = "supplier_name",property = "supplierName"),
            @Result(column = "supplier_type",property = "supplierType"),
            @Result(column = "link_man",property = "linkMan"),
            @Result(column = "phone_number",property = "phoneNumber"),
            @Result(column = "bank_name",property = "bankName"),
            @Result(column = "bank_account",property = "bankAccount"),
            @Result(column = "address",property = "address"),
            @Result(column = "supplier_status",property = "supplierStatus"),
            @Result(column = "modified_time",property = "modifiedTime")
    })
    List<ProductSupplierInfo> selectAll();
}