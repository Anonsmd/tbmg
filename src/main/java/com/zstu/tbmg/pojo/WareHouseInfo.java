package com.zstu.tbmg.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Database Table Remarks:
 *   仓库信息表
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table warehouse_info
 *
 * @mbg.generated do_not_delete_during_merge 2021-01-07 15:15:20
 */
public class WareHouseInfo implements Serializable {
    /**
     * Database Column Remarks:
     *   仓库ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.warehouse_id
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private Integer warehouseId;

    /**
     * Database Column Remarks:
     *   仓库编码
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.warehouse_sn
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private String warehouseSn;

    /**
     * Database Column Remarks:
     *   仓库名称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.warehouse_name
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private String warehouseName;

    /**
     * Database Column Remarks:
     *   仓库电话
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.warehouse_phone
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private String warehousePhone;

    /**
     * Database Column Remarks:
     *   仓库联系人
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.contact
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private String contact;

    /**
     * Database Column Remarks:
     *   省
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.province
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private String province;

    /**
     * Database Column Remarks:
     *   市
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.city
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private String city;

    /**
     * Database Column Remarks:
     *   区
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.distrct
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private String distrct;

    /**
     * Database Column Remarks:
     *   仓库地址
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.address
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private String address;

    /**
     * Database Column Remarks:
     *   仓库状态：0禁用，1启用
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.warehouse_status
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private Byte warehouseStatus;

    /**
     * Database Column Remarks:
     *   最后修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehouse_info.modified_time
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private Date modifiedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table warehouse_info
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.warehouse_id
     *
     * @return the value of warehouse_info.warehouse_id
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public Integer getWarehouseId() {
        return warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.warehouse_id
     *
     * @param warehouseId the value for warehouse_info.warehouse_id
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.warehouse_sn
     *
     * @return the value of warehouse_info.warehouse_sn
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public String getWarehouseSn() {
        return warehouseSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.warehouse_sn
     *
     * @param warehouseSn the value for warehouse_info.warehouse_sn
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setWarehouseSn(String warehouseSn) {
        this.warehouseSn = warehouseSn == null ? null : warehouseSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.warehouse_name
     *
     * @return the value of warehouse_info.warehouse_name
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public String getWarehouseName() {
        return warehouseName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.warehouse_name
     *
     * @param warehouseName the value for warehouse_info.warehouse_name
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.warehouse_phone
     *
     * @return the value of warehouse_info.warehouse_phone
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public String getWarehousePhone() {
        return warehousePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.warehouse_phone
     *
     * @param warehousePhone the value for warehouse_info.warehouse_phone
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setWarehousePhone(String warehousePhone) {
        this.warehousePhone = warehousePhone == null ? null : warehousePhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.contact
     *
     * @return the value of warehouse_info.contact
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public String getContact() {
        return contact;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.contact
     *
     * @param contact the value for warehouse_info.contact
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.province
     *
     * @return the value of warehouse_info.province
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.province
     *
     * @param province the value for warehouse_info.province
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.city
     *
     * @return the value of warehouse_info.city
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.city
     *
     * @param city the value for warehouse_info.city
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.distrct
     *
     * @return the value of warehouse_info.distrct
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public String getDistrct() {
        return distrct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.distrct
     *
     * @param distrct the value for warehouse_info.distrct
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setDistrct(String distrct) {
        this.distrct = distrct == null ? null : distrct.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.address
     *
     * @return the value of warehouse_info.address
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.address
     *
     * @param address the value for warehouse_info.address
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.warehouse_status
     *
     * @return the value of warehouse_info.warehouse_status
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public Byte getWarehouseStatus() {
        return warehouseStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.warehouse_status
     *
     * @param warehouseStatus the value for warehouse_info.warehouse_status
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setWarehouseStatus(Byte warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehouse_info.modified_time
     *
     * @return the value of warehouse_info.modified_time
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehouse_info.modified_time
     *
     * @param modifiedTime the value for warehouse_info.modified_time
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table warehouse_info
     *
     * @mbg.generated 2021-01-07 15:15:20
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", warehouseSn=").append(warehouseSn);
        sb.append(", warehouseName=").append(warehouseName);
        sb.append(", warehousePhone=").append(warehousePhone);
        sb.append(", contact=").append(contact);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", distrct=").append(distrct);
        sb.append(", address=").append(address);
        sb.append(", warehouseStatus=").append(warehouseStatus);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}