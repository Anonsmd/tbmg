package com.zstu.tbmg.dto;

import com.zstu.tbmg.pojo.ProductCategory;

import java.util.Date;
import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 15:32
 */
public class ProductCategoryWithChildren {
    private Integer categoryId;
    private String categoryName;
    private String categoryCode;
    private Integer parentId;
    private Byte categoryLevel;
    private Byte categoryStatus;
    private Date modifiedTime;
    private List<ProductCategory> children;

    @Override
    public String toString() {
        return "ProductCategoryWithChildren{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", parentId=" + parentId +
                ", categoryLevel=" + categoryLevel +
                ", categoryStatus=" + categoryStatus +
                ", modifiedTime=" + modifiedTime +
                ", children=" + children +
                '}';
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Byte getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(Byte categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    public Byte getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Byte categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<ProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ProductCategory> children) {
        this.children = children;
    }
}
