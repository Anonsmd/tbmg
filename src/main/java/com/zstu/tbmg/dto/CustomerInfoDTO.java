package com.zstu.tbmg.dto;

import com.zstu.tbmg.pojo.CustomerAddr;
import com.zstu.tbmg.pojo.CustomerInf;
import com.zstu.tbmg.pojo.CustomerLogin;
import com.zstu.tbmg.pojo.ProductInfo;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/8 16:27
 */
public class CustomerInfoDTO {
    private Integer customerId;
    private CustomerLogin customerLogin;
    private CustomerInf customerInf;
    private CustomerAddr customerAddr;
    private List<ProductInfo> productList;

    public List<ProductInfo> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductInfo> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "CustomerInfoDTO{" +
                "customerId=" + customerId +
                ", customerLogin=" + customerLogin +
                ", customerInf=" + customerInf +
                ", customerAddr=" + customerAddr +
                ", productList=" + productList +
                '}';
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerLogin getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(CustomerLogin customerLogin) {
        this.customerLogin = customerLogin;
    }

    public CustomerInf getCustomerInf() {
        return customerInf;
    }

    public void setCustomerInf(CustomerInf customerInf) {
        this.customerInf = customerInf;
    }

    public CustomerAddr getCustomerAddr() {
        return customerAddr;
    }

    public void setCustomerAddr(CustomerAddr customerAddr) {
        this.customerAddr = customerAddr;
    }
}
