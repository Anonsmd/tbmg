package com.zstu.tbmg.dto;

import java.util.Date;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 22:20
 */
public class ShippingUpdateDTO {
    private Integer orderDetailId;
    private String deliveryCompany;
    private String deliverySn;

    @Override
    public String toString() {
        return "ShippingUpdateDTO{" +
                "orderDetailId=" + orderDetailId +
                ", deliveryCompany='" + deliveryCompany + '\'' +
                ", deliverySn='" + deliverySn + '\'' +
                '}';
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliverySn() {
        return deliverySn;
    }

    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }
}
