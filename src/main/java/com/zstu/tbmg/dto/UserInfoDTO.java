package com.zstu.tbmg.dto;

import java.util.List;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/5 21:44
 */
public class UserInfoDTO {
    private String username;
    private String icon;
    private List<String> roles;

    @Override
    public String toString() {
        return "UserInfoDTO{" +
                "username='" + username + '\'' +
                ", icon='" + icon + '\'' +
                ", roles=" + roles +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getIcon() {
        return icon;
    }

    public List<String> getRoles() {
        return roles;
    }
}
