package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.OrderDTO;
import com.zstu.tbmg.dto.OrderMasterListDTO;
import com.zstu.tbmg.dto.ProductInfoDTO;
import com.zstu.tbmg.dto.ShippingUpdateDTO;
import com.zstu.tbmg.mapper.db2.OrderDetailMapper;
import com.zstu.tbmg.mapper.db2.OrderShippingInfoMapper;
import com.zstu.tbmg.mapper.db2.OrderSmallMapper;
import com.zstu.tbmg.mapper.db2.ProductInfoMapper;
import com.zstu.tbmg.pojo.*;
import com.zstu.tbmg.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 20:33
 */
@Service
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderSmallMapper orderSmallMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private OrderShippingInfoMapper orderShippingInfoMapper;
    @Autowired
    private ProductInfoMapper productInfoMapper;
    @Override
    public OrderMasterListDTO getList(int pageNum, int pageSize, Long orderSn, String loginName, Byte orderStatus, Byte paymentMethod) throws Exception {
        OrderSmallExample orderSmallExample = new OrderSmallExample();
        OrderSmallExample.Criteria criteria = orderSmallExample.createCriteria();
        if (orderSn!=null){
            criteria.andOrderSnEqualTo(orderSn);
        }
        if (loginName!=null && loginName.length()>0){
            criteria.andLoginNameLike('%'+loginName+'%');
        }
        if (orderStatus!=null){
            criteria.andOrderStatusEqualTo(orderStatus);
        }
        if (paymentMethod!=null){
            criteria.andPaymentMethodEqualTo(paymentMethod);
        }
        List<OrderSmall> answList = new ArrayList<>();
        answList = orderSmallMapper.selectByExample(orderSmallExample);
        int total = answList.size();
        OrderMasterListDTO answ = new OrderMasterListDTO();
        if (total<=pageSize){
            answ.setList(answList);
        }
        else{
            if ((pageNum-1)*pageSize+pageSize<total){
                answ.setList(answList.subList((pageNum - 1) * pageSize, (pageNum - 1) * pageSize + pageSize));
            }
            else{
                answ.setList(answList.subList((pageNum - 1) * pageSize,total));
            }
        }
        answ.setPageNum(pageNum);
        answ.setPageSize(pageSize);
        answ.setTotal(total);
        answ.setTotalPage((total+pageSize-1)/pageSize);
        return answ;
    }

    @Override
    public OrderShippingInfo getShipingInfoByOrderSn(Integer orderId) throws Exception{
        OrderShippingInfoExample orderShippingInfoExample = new OrderShippingInfoExample();
        orderShippingInfoExample.createCriteria().andOrderDetailIdEqualTo(orderId);
        List<OrderShippingInfo> answ = orderShippingInfoMapper.selectByExample(orderShippingInfoExample);
        if (answ.size()!=1){
            throw new Exception("错误订单");
        }
        return answ.get(0);
    }

    @Override
    public boolean updateShippingInfo(ShippingUpdateDTO shippingUpdateDTO) throws Exception {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(shippingUpdateDTO.getOrderDetailId());
        orderDetail.setShippingCompName(shippingUpdateDTO.getDeliveryCompany());
        orderDetail.setShippingSn(shippingUpdateDTO.getDeliverySn());
        orderDetail.setOrderStatus((byte) 2);
        orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
        return true;
    }

    @Override
    public OrderDTO getDetailInfo(Integer orderDTO) throws Exception {
        return null;
    }
}
