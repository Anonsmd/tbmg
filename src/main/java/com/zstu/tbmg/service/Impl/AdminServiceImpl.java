package com.zstu.tbmg.service.Impl;

import com.zstu.tbmg.dto.AdminUserDetails;
import com.zstu.tbmg.mapper.db1.RoleMapper;
import com.zstu.tbmg.mapper.db1.UserMapper;
import com.zstu.tbmg.mapper.db2.CustomerLoginMapper;
import com.zstu.tbmg.pojo.Role;
import com.zstu.tbmg.pojo.RoleExample;
import com.zstu.tbmg.pojo.User;
import com.zstu.tbmg.pojo.UserExample;
import com.zstu.tbmg.service.AdminService;
import com.zstu.tbmg.util.JwtTokenUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Transactional
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private CustomerLoginMapper customerLoginMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    public String login(String username, String password) throws Exception{
        customerLoginMapper.selectByPrimaryKey(1);
        AdminUserDetails userDetails = null;
//        User user = userMapper.selectByPrimaryKey(username);
        User user;
//        example = userMapper.selectByPrimaryKey(username);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        user = userMapper.selectByExample(userExample).get(0);
        if(user == null){
            throw new BadCredentialsException("账户或密码不正确");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("your password"+password+" correct:"+ user.getPassword());
            throw new BadCredentialsException("密码不正确");
        }
        RoleExample roleExample=new RoleExample();
        roleExample.createCriteria().andUseridEqualTo(user.getUsername());
        List<Role> roles=roleMapper.selectByExample(roleExample);
        userDetails = new AdminUserDetails(user,roles);
//            userDetails = new AdminUserDetails(user,null);
        //   UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        //  SecurityContextHolder.getContext().setAuthentication(authentication);
//        } catch (AuthenticationException e) {
//            LOGGER.warn("登录异常:{}", e.getMessage());
//        }
//        try{
        if(userDetails == null){
            throw new BadCredentialsException("密码不正确");
        }
        else{
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
//        }
//        catch (AuthenticationException e) {
//            LOGGER.warn("登录异常:{}", e.getMessage());
//            return null;
//        }
        return jwtTokenUtil.generateToken(userDetails);
    }



    @Override
    public User getAdminByUsername(String username)  throws Exception{
        User example;
//        example = userMapper.selectByPrimaryKey(username);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        example = userMapper.selectByExample(userExample).get(0);
        return example;
    }

    @Override
    public User register(User user,String Type) throws Exception {
        User umsAdmin = new User();
        BeanUtils.copyProperties(user, umsAdmin);
        umsAdmin.setId(UUID.randomUUID().toString());
        if (checkIfUserExist(umsAdmin.getUsername())) {
            throw new Exception("该账号已存在");
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        userMapper.insertSelective(umsAdmin);
        Role role=new Role();
//        role.setCreateTime(new Date());
        role.setUserid(umsAdmin.getId());
        String roleType= Type;
        role.setName(roleType);
        role.setType(roleType);
        roleMapper.insertSelective(role);
        return umsAdmin;
    }

    @Override
    public void logout(String username) throws Exception {

    }

    private boolean checkIfUserExist(String username) throws Exception{
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size()==0){
            return false;
        }
        return true;
    }
}
