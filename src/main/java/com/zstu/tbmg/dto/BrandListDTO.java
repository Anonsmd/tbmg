package com.zstu.tbmg.dto;

import com.zstu.tbmg.pojo.ProductBrandInfo;
import com.zstu.tbmg.pojo.ProductInfo;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 12:59
 */
public class BrandListDTO {
    private int pageNum;
    private int pageSize;
    private int totalPage;
    private int total;
    private List<ProductBrandInfo> list;

    @Override
    public String toString() {
        return "BrandListDTO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", total=" + total +
                ", list=" + list +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
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

    public List<ProductBrandInfo> getList() {
        return list;
    }

    public void setList(List<ProductBrandInfo> list) {
        this.list = list;
    }
}
