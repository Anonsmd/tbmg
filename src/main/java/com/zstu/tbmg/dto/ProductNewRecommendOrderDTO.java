package com.zstu.tbmg.dto;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 17:30
 */
public class ProductNewRecommendOrderDTO {
    private Integer newRecommendId;
    private Byte productOrder;

    @Override
    public String toString() {
        return "ProductNewRecommendOrderDTO{" +
                "newRecommendId=" + newRecommendId +
                ", productOrder=" + productOrder +
                '}';
    }

    public Integer getNewRecommendId() {
        return newRecommendId;
    }

    public void setNewRecommendId(Integer newRecommendId) {
        this.newRecommendId = newRecommendId;
    }

    public Byte getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Byte productOrder) {
        this.productOrder = productOrder;
    }
}
