package com.zstu.tbmg.dto;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 17:30
 */
public class BrandOrderDTO {
    private Integer brandId;
    private Byte brandOrder;

    @Override
    public String toString() {
        return "BrandOrderDTO{" +
                "brandId=" + brandId +
                ", brandOrder=" + brandOrder +
                '}';
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Byte getBrandOrder() {
        return brandOrder;
    }

    public void setBrandOrder(Byte brandOrder) {
        this.brandOrder = brandOrder;
    }
}
