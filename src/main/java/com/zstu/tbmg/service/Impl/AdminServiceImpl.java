package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.AdminUserDetails;
import com.zstu.tbmg.dto.UserInfoDTO;
import com.zstu.tbmg.mapper.db1.ManagerLoginMapper;
import com.zstu.tbmg.mapper.db1.ManagerRoleMapper;
import com.zstu.tbmg.pojo.ManagerLogin;
import com.zstu.tbmg.pojo.ManagerRole;
import com.zstu.tbmg.service.AdminService;
import com.zstu.tbmg.util.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ManagerLoginMapper managerLoginMapper;
    @Autowired
    private ManagerRoleMapper managerRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String login(String username, String password) throws Exception{
        AdminUserDetails userDetails = null;
        List<ManagerLogin> userList = managerLoginMapper.selectByUsername(username);
        if (userList.size()!=1){
            throw new Exception("账户名不存在或者重合，请重新输入");
        }
        ManagerLogin user;
        user = userList.get(0);
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("your password"+password+" correct:"+ user.getPassword());
            throw new BadCredentialsException("密码不正确");
        }
        List<ManagerRole> roleList=managerRoleMapper.selectByUserID(user.getManagerId());
        if (roleList.size() == 0){
            throw new Exception("角色身份为空，请核实");
        }
        userDetails = new AdminUserDetails(user,roleList);
        if(userDetails == null){
            throw new BadCredentialsException("密码不正确");
        }
        else{
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        return jwtTokenUtil.generateToken(userDetails);
    }



    @Override
    public ManagerLogin getAdminByUsername(String username)  throws Exception{
        List<ManagerLogin> answList = managerLoginMapper.selectByUsername(username);
        if (answList.size()!=1){
            throw new Exception("账户名出现重合,请重新输入");
        }
        return answList.get(0);
    }

    @Override
    @Transactional
    public ManagerLogin register(ManagerLogin user,String Type) throws Exception {
        ManagerLogin umsAdmin = new ManagerLogin();
        BeanUtils.copyProperties(user, umsAdmin);
        if (checkIfUserExist(umsAdmin.getLoginName())) {
            throw new Exception("该账号已存在");
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        managerLoginMapper.insert(umsAdmin);
        ManagerRole role=new ManagerRole();
        role.setManagerId(managerLoginMapper.getAutoIncrement());
        String roleType= Type;
        role.setRoleName(roleType);
        role.setRoleType(roleType);
        role.setRoleInfo(roleType);
        managerRoleMapper.insertSelectiveWithoutID(role);
        return umsAdmin;
    }

    @Override
    public boolean logout(String username) throws Exception {
        /**
         * 去他喵的登出，不想搞redis,没有登出
         */
        return true;
    }

    @Override
    public UserInfoDTO getInfo(String username) throws Exception{
        UserInfoDTO answ = new UserInfoDTO();
        List<ManagerRole> roleList = managerRoleMapper.selectByUsername(username);
        answ.setUsername(username);
        answ.setRoles(roleList.stream()
                .filter(role->role.getRoleType()!=null)
                .map(role->role.getRoleType())
                .collect(Collectors.toList()));
        return answ;
    }

    private boolean checkIfUserExist(String username) throws Exception{
        List<ManagerLogin> checkList = managerLoginMapper.selectByUsername(username);
        if (checkList.size()==0){
            return false;
        }
        return true;
    }
}
