package com.zstu.tbmg.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   供应商信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table product_supplier_info
 *
 * @mbg.generated do_not_delete_during_merge 2021-01-06 13:12:18
 */
public class ProductSupplierInfo implements Serializable {
    /**
     * Database Column Remarks:
     *   供应商ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.supplier_id
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private Integer supplierId;

    /**
     * Database Column Remarks:
     *   供应商编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.supplier_code
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private String supplierCode;

    /**
     * Database Column Remarks:
     *   供应商名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.supplier_name
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private String supplierName;

    /**
     * Database Column Remarks:
     *   供应商类型：1.自营，2.平台
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.supplier_type
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private Byte supplierType;

    /**
     * Database Column Remarks:
     *   供应商联系人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.link_man
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private String linkMan;

    /**
     * Database Column Remarks:
     *   联系电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.phone_number
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private String phoneNumber;

    /**
     * Database Column Remarks:
     *   供应商开户银行名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.bank_name
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private String bankName;

    /**
     * Database Column Remarks:
     *   银行账号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.bank_account
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private String bankAccount;

    /**
     * Database Column Remarks:
     *   供应商地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.address
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private String address;

    /**
     * Database Column Remarks:
     *   状态：0禁止，1启用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.supplier_status
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private Byte supplierStatus;

    /**
     * Database Column Remarks:
     *   最后修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column product_supplier_info.modified_time
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private Date modifiedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table product_supplier_info
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.supplier_id
     *
     * @return the value of product_supplier_info.supplier_id
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.supplier_id
     *
     * @param supplierId the value for product_supplier_info.supplier_id
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.supplier_code
     *
     * @return the value of product_supplier_info.supplier_code
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.supplier_code
     *
     * @param supplierCode the value for product_supplier_info.supplier_code
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.supplier_name
     *
     * @return the value of product_supplier_info.supplier_name
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.supplier_name
     *
     * @param supplierName the value for product_supplier_info.supplier_name
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.supplier_type
     *
     * @return the value of product_supplier_info.supplier_type
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public Byte getSupplierType() {
        return supplierType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.supplier_type
     *
     * @param supplierType the value for product_supplier_info.supplier_type
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setSupplierType(Byte supplierType) {
        this.supplierType = supplierType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.link_man
     *
     * @return the value of product_supplier_info.link_man
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.link_man
     *
     * @param linkMan the value for product_supplier_info.link_man
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.phone_number
     *
     * @return the value of product_supplier_info.phone_number
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.phone_number
     *
     * @param phoneNumber the value for product_supplier_info.phone_number
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.bank_name
     *
     * @return the value of product_supplier_info.bank_name
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.bank_name
     *
     * @param bankName the value for product_supplier_info.bank_name
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.bank_account
     *
     * @return the value of product_supplier_info.bank_account
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.bank_account
     *
     * @param bankAccount the value for product_supplier_info.bank_account
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.address
     *
     * @return the value of product_supplier_info.address
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.address
     *
     * @param address the value for product_supplier_info.address
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.supplier_status
     *
     * @return the value of product_supplier_info.supplier_status
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public Byte getSupplierStatus() {
        return supplierStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.supplier_status
     *
     * @param supplierStatus the value for product_supplier_info.supplier_status
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setSupplierStatus(Byte supplierStatus) {
        this.supplierStatus = supplierStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column product_supplier_info.modified_time
     *
     * @return the value of product_supplier_info.modified_time
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column product_supplier_info.modified_time
     *
     * @param modifiedTime the value for product_supplier_info.modified_time
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table product_supplier_info
     *
     * @mbg.generated 2021-01-06 13:12:18
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierCode=").append(supplierCode);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", supplierType=").append(supplierType);
        sb.append(", linkMan=").append(linkMan);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", address=").append(address);
        sb.append(", supplierStatus=").append(supplierStatus);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}