package com.zstu.tbmg.controller;

import com.zstu.tbmg.api.CommonResult;
import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.CustomerListDTO;
import com.zstu.tbmg.service.CustomerService;
import com.zstu.tbmg.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/8 14:17
 */
@Controller
@Api(tags = "CustomerController", description = "用户管理")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    private String GetUsername(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取用户名
        String authHeader = request.getHeader(this.tokenHeader);
        String username=null;
        if (authHeader != null) {
            username = jwtTokenUtil.getUserNameFromToken(authHeader);
        }
        return username;
    }

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getList(@RequestParam(value="pageNum")int pageNum, @RequestParam(value="pageSize")int pageSize,
                                                      @RequestParam(value="customerName",required = false)String customerName
    ){
        CustomerListDTO answ;
        try {
            answ = customerService.getList(pageNum,pageSize,customerName);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }

    @ApiOperation(value = "更新有效状态")
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> updateStatus(@RequestBody List<Integer> ids){
        boolean answ;
        try {
            answ = customerService.updateStatus(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        Map<String, Boolean> answMap = new HashMap<>();
        answMap.put("isSuccess",answ);
        return CommonResult.success(answMap);
    }
}
