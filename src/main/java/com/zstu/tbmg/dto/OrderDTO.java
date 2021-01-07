package com.zstu.tbmg.dto;

import com.zstu.tbmg.pojo.OrderDetail;
import com.zstu.tbmg.pojo.OrderShippingInfo;
import com.zstu.tbmg.pojo.ProductInfo;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 22:45
 */
public class OrderDTO {
    private Integer orderDetailId;
    private OrderDetail orderDetail;
    private ProductInfo productInfo;
    private OrderShippingInfo orderShippingInfo;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDetailId=" + orderDetailId +
                ", orderDetail=" + orderDetail +
                ", productInfo=" + productInfo +
                ", orderShippingInfo=" + orderShippingInfo +
                '}';
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    public ProductInfo getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(ProductInfo productInfo) {
        this.productInfo = productInfo;
    }

    public OrderShippingInfo getOrderShippingInfo() {
        return orderShippingInfo;
    }

    public void setOrderShippingInfo(OrderShippingInfo orderShippingInfo) {
        this.orderShippingInfo = orderShippingInfo;
    }
}
