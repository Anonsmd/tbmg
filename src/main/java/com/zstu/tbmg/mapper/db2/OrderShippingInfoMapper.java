package com.zstu.tbmg.mapper.db2;

import com.zstu.tbmg.pojo.OrderShippingInfo;
import com.zstu.tbmg.pojo.OrderShippingInfoExample;
import java.util.List;

public interface OrderShippingInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_info
     *
     * @mbg.generated 2021-01-07 21:59:06
     */
    int insert(OrderShippingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_info
     *
     * @mbg.generated 2021-01-07 21:59:06
     */
    int insertSelective(OrderShippingInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_shipping_info
     *
     * @mbg.generated 2021-01-07 21:59:06
     */
    List<OrderShippingInfo> selectByExample(OrderShippingInfoExample example);
}