package com.zstu.tbmg.service;



import com.zstu.tbmg.dto.UserInfoDTO;
import com.zstu.tbmg.pojo.ManagerLogin;

import java.util.List;

public interface AdminService {

    String login(String username, String password) throws Exception;
    ManagerLogin getAdminByUsername(String username) throws Exception;
    ManagerLogin register(ManagerLogin user,String Type) throws Exception;

    boolean logout(String username) throws Exception;

    UserInfoDTO getInfo(String username) throws Exception;
}
