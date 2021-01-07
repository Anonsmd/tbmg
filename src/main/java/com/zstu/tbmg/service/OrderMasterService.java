package com.zstu.tbmg.service;

import com.zstu.tbmg.dto.OrderDTO;
import com.zstu.tbmg.dto.OrderMasterListDTO;
import com.zstu.tbmg.dto.ShippingUpdateDTO;
import com.zstu.tbmg.pojo.OrderShippingInfo;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 20:33
 */
public interface OrderMasterService {
    OrderMasterListDTO getList(int pageNum, int pageSize, Long orderSn, String loginName, Byte orderStatus, Byte paymentMethod) throws Exception;

    OrderShippingInfo getShipingInfoByOrderSn(Integer orderId) throws Exception;

    boolean updateShippingInfo(ShippingUpdateDTO shippingUpdateDTO) throws Exception;

    OrderDTO getDetailInfo(Integer orderDTO) throws Exception;
}
