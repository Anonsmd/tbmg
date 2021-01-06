package com.zstu.tbmg.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table manager_role
 *
 * @mbg.generated do_not_delete_during_merge 2021-01-05 15:09:42
 */
public class ManagerRole implements Serializable {
    /**
     * Database Column Remarks:
     *   角色ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_role.role_id
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    private Integer roleId;

    /**
     * Database Column Remarks:
     *   管理员ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_role.manager_id
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    private Integer managerId;

    /**
     * Database Column Remarks:
     *   角色名
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_role.role_name
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    private String roleName;

    /**
     * Database Column Remarks:
     *   角色类型
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_role.role_type
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    private String roleType;

    /**
     * Database Column Remarks:
     *   角色描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_role.role_info
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    private String roleInfo;

    /**
     * Database Column Remarks:
     *   最后修改时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column manager_role.modified_time
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    private Date modifiedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table manager_role
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_role.role_id
     *
     * @return the value of manager_role.role_id
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_role.role_id
     *
     * @param roleId the value for manager_role.role_id
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_role.manager_id
     *
     * @return the value of manager_role.manager_id
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_role.manager_id
     *
     * @param managerId the value for manager_role.manager_id
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_role.role_name
     *
     * @return the value of manager_role.role_name
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_role.role_name
     *
     * @param roleName the value for manager_role.role_name
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_role.role_type
     *
     * @return the value of manager_role.role_type
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_role.role_type
     *
     * @param roleType the value for manager_role.role_type
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType == null ? null : roleType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_role.role_info
     *
     * @return the value of manager_role.role_info
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public String getRoleInfo() {
        return roleInfo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_role.role_info
     *
     * @param roleInfo the value for manager_role.role_info
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo == null ? null : roleInfo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column manager_role.modified_time
     *
     * @return the value of manager_role.modified_time
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column manager_role.modified_time
     *
     * @param modifiedTime the value for manager_role.modified_time
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table manager_role
     *
     * @mbg.generated 2021-01-05 15:09:42
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", managerId=").append(managerId);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleType=").append(roleType);
        sb.append(", roleInfo=").append(roleInfo);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}