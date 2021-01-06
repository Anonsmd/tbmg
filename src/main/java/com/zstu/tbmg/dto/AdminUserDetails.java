package com.zstu.tbmg.dto;

import com.zstu.tbmg.pojo.ManagerLogin;
import com.zstu.tbmg.pojo.ManagerRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AdminUserDetails implements UserDetails {
    private ManagerLogin umsAdmin;
    private List<ManagerRole> permissionList;

    public ManagerLogin getUmsAdmin() {
        return umsAdmin;
    }

    public void setUmsAdmin(ManagerLogin umsAdmin) {
        this.umsAdmin = umsAdmin;
    }

    public List<ManagerRole> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<ManagerRole> permissionList) {
        this.permissionList = permissionList;
    }

    public AdminUserDetails(){

    }
    public AdminUserDetails(ManagerLogin umsAdmin, List<ManagerRole> list) {
        this.umsAdmin = umsAdmin;
        this.permissionList = list;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        System.out.println(permissionList.get(0));
        //返回当前用户的权限
        return permissionList.stream()
                .filter(permission -> permission.getRoleType()  !=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getRoleType()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return umsAdmin.getPassword();
    }

    @Override
    public String getUsername() {
        return umsAdmin.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
     //   return umsAdmin.getStatus().equals(1);
        return true;
    }
}
