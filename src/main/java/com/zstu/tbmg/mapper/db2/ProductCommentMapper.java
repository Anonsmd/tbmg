package com.zstu.tbmg.mapper.db2;

import com.zstu.tbmg.pojo.ProductComment;

public interface ProductCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_comment
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    int deleteByPrimaryKey(Integer commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_comment
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    int insert(ProductComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_comment
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    int insertSelective(ProductComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_comment
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    ProductComment selectByPrimaryKey(Integer commentId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_comment
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    int updateByPrimaryKeySelective(ProductComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_comment
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    int updateByPrimaryKey(ProductComment record);
}