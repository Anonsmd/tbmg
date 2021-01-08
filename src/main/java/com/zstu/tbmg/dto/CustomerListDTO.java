package com.zstu.tbmg.dto;

import com.zstu.tbmg.pojo.CustomerMaster;
import com.zstu.tbmg.pojo.ProductBrandInfo;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 12:59
 */
public class CustomerListDTO {
    private int pageNum;
    private int pageSize;
    private int totalPage;
    private int total;
    private List<CustomerMaster> list;

    @Override
    public String toString() {
        return "CustomerListDTO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", total=" + total +
                ", list=" + list +
                '}';
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CustomerMaster> getList() {
        return list;
    }

    public void setList(List<CustomerMaster> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
