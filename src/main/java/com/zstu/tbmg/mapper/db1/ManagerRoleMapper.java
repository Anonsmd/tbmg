package com.zstu.tbmg.mapper.db1;

import com.zstu.tbmg.pojo.ManagerRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ManagerRoleMapper {

    @Select("select manager_role.* from manager_role left join manager_login on manager_login.manager_id = manager_role.manager_id where manager_login.login_name = #{username};")
    @Results(id = "roleMap", value={
            @Result(id = true, column = "role_id", property = "roleId"),
            @Result(column = "manager_id", property = "managerId"),
            @Result(column = "role_name", property = "roleName"),
            @Result(column = "role_type", property = "roleType"),
            @Result(column = "role_info", property = "roleInfo"),
            @Result(column = "modified_time", property = "modifiedTime")

    })
    List<ManagerRole> selectByUsername(@Param("username") String username);

    @Insert("insert into manager_role(manager_id,role_name,role_type,role_info) values(#{managerId},#{roleName},#{roleType},#{roleInfo})")
    void insertSelectiveWithoutID(ManagerRole role);

    @Select("select * from manager_role where manager_id = #{managerId}")
    @ResultMap(value = "roleMap")
    List<ManagerRole> selectByUserID(@Param("managerId") Integer managerId);

    @Select("select manager_role.role_type from manager_role left join manager_login on manager_login.manager_id = manager_role.manager_id where manager_login.login_name = #{username};")
    String selectRoleTypeByUsername(@Param("username") String username);

    @Select("select @@identity")
    Integer getAutoIncrement();
}