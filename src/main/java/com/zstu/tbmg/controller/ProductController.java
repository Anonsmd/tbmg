package com.zstu.tbmg.controller;

import com.zstu.tbmg.api.CommonResult;
import com.zstu.tbmg.dto.ProductListDTO;
import com.zstu.tbmg.pojo.ProductInfo;
import com.zstu.tbmg.service.ProductService;
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
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/6 12:52
 */
@Controller
@Api(tags = "ProductController", description = "产品管理")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
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
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getList(@RequestParam(value="pageNum")int pageNum,
                                                      @RequestParam(value="pageSize")int pageSize,
                                                      @RequestParam(value = "keyword",required = false)String keyword,
                                                      @RequestParam(value = "publishStatus",required = false)Byte publishStatus,
                                                      @RequestParam(value = "verifyStatus",required = false)Byte verifyStatus,
                                                      @RequestParam(value = "productSn",required = false)String productSn,
                                                      @RequestParam(value = "productCategoryId",required = false)Integer productCategory,
                                                      @RequestParam(value = "brandId",required = false)Integer brandId
                                                      ){
        ProductListDTO answ;
        try {
            answ = productService.getList(pageNum,pageSize,keyword,publishStatus,verifyStatus,productSn,productCategory,brandId);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }

    @ApiOperation(value = "获取商品更新信息")
    @RequestMapping(value = "/updateInfo/{productId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getProduct(@PathVariable Integer productId){
        ProductInfo answ;
        try {
            answ = productService.getProduct(productId);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }

    @ApiOperation(value = "更深上架状态")
    @RequestMapping(value = "/update/publishStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> updatePublishStatus(@RequestBody List<Integer> ids){
        boolean answ;
        try {
            answ = productService.updatePublishStatus(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        Map<String, Boolean> answMap = new HashMap<>();
        answMap.put("isSuccess",answ);
        return CommonResult.success(answMap);
    }

    @ApiOperation(value = "更新审核状态")
    @RequestMapping(value = "/update/verifyStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> updateVerifyStatus(@RequestBody List<Integer> ids){
        boolean answ;
        try {
            answ = productService.updateVerifyStatus(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        Map<String, Boolean> answMap = new HashMap<>();
        answMap.put("isSuccess",answ);
        return CommonResult.success(answMap);
    }
}
