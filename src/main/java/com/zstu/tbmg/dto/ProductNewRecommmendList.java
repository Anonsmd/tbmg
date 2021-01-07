package com.zstu.tbmg.dto;

import com.zstu.tbmg.pojo.ProductBrandInfo;
import com.zstu.tbmg.pojo.ProductNewRecommend;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 18:10
 */
public class ProductNewRecommmendList {
    private int pageNum;
    private int pageSize;
    private int totalPage;
    private int total;
    private List<ProductNewRecommend> list;

    @Override
    public String toString() {
        return "ProductNewRecommmendList{" +
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

    public List<ProductNewRecommend> getList() {
        return list;
    }

    public void setList(List<ProductNewRecommend> list) {
        this.list = list;
    }
}
