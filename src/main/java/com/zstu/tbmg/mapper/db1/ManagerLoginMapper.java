package com.zstu.tbmg.mapper.db1;

import com.zstu.tbmg.pojo.ManagerLogin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ManagerLoginMapper {

    @Select("select * from manager_login where login_name = #{username};")
    @Results(id = "roleMap", value={
            @Result(id = true, column = "manager_id", property = "managerId"),
            @Result(column = "login_name", property = "loginName"),
            @Result(column = "password", property = "password"),
            @Result(column = "user_stats", property = "userStats"),
            @Result(column = "modified_time", property = "modifiedTime")

    })
    List<ManagerLogin> selectByUsername(@Param("username") String username);

    @Insert("insert into manager_login(login_name,password) values(#{loginName},#{password});")
    void insert(ManagerLogin user);

    @Select("select manager_id from manager_login where loginName = #{username};")
    List<String> selectManagerIDByUsername(@Param("username")String username);

    @Select("select @@identity")
    Integer getAutoIncrement();
}