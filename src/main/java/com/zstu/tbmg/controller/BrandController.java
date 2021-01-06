package com.zstu.tbmg.controller;

import com.zstu.tbmg.api.CommonResult;
import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.ProductListDTO;
import com.zstu.tbmg.service.BrandService;
import com.zstu.tbmg.service.ProductService;
import com.zstu.tbmg.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 14:44
 */
@Controller
@Api(tags = "BrandController", description = "品牌管理")
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
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

    @ApiOperation(value = "获取品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getList(@RequestParam(value="pageNum")int pageNum, @RequestParam(value="pageSize")int pageSize){
        BrandListDTO answ;
        try {
            answ = brandService.getList(pageNum,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }
}
