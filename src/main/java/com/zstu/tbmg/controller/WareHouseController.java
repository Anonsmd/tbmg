package com.zstu.tbmg.controller;

import com.zstu.tbmg.api.CommonResult;
import com.zstu.tbmg.dto.ProductListDTO;
import com.zstu.tbmg.pojo.ProductInfo;
import com.zstu.tbmg.pojo.WareHouseInfo;
import com.zstu.tbmg.pojo.WareHouseProduct;
import com.zstu.tbmg.service.ProductService;
import com.zstu.tbmg.service.WareHouseService;
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
 * @Date: 2021/1/7 15:19
 */
@Controller
@Api(tags = "WareHouseController", description = "仓库管理")
@RequestMapping("/warehouse")
public class WareHouseController {
    @Autowired
    private WareHouseService wareHouseService;
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

    @ApiOperation(value = "获取商品列表")
    @RequestMapping(value = "/infoList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getInfoList(){
        List<WareHouseInfo> answ;
        try {
            answ = wareHouseService.getInfoList();
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }

    @ApiOperation(value = "创建仓库")
    @RequestMapping(value = "/product/createOrUpdate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> createOrUpdate(@RequestBody WareHouseProduct wareHouseProduct){
        boolean answ;
        try {
            answ = wareHouseService.createOrUpdate(wareHouseProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }
}
