package com.zstu.tbmg.controller;

import com.zstu.tbmg.api.CommonResult;
import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.BrandOrderDTO;
import com.zstu.tbmg.dto.ProductNewRecommendOrderDTO;
import com.zstu.tbmg.dto.ProductNewRecommmendList;
import com.zstu.tbmg.service.BrandService;
import com.zstu.tbmg.service.ProductNewRecommendService;
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
 * @Date: 2021/1/6 14:44
 */
@Controller
@Api(tags = "ProductNewRecommendController", description = "品牌管理")
@RequestMapping("/newRecommend")
public class ProductNewRecommendController {
    @Autowired
    private ProductNewRecommendService productNewRecommendService;
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

    @ApiOperation(value = "获取新品列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getList(@RequestParam(value="pageNum")int pageNum, @RequestParam(value="pageSize")int pageSize,
                                                      @RequestParam(value="productName",required = false)String productName,
                                                      @RequestParam(value="recommendStatus",required = false)Byte recommendStatus
    ){
        ProductNewRecommmendList answ;
        try {
            answ = productNewRecommendService.getList(pageNum,pageSize,productName,recommendStatus);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }

    @ApiOperation(value = "设置新品排序")
    @RequestMapping(value = "/setOrder", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> setOrder(@RequestBody ProductNewRecommendOrderDTO productNewRecommendOrderDTO){
        boolean answ;
        try {
            answ = productNewRecommendService.setOrder(productNewRecommendOrderDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        Map<String, Boolean> answMap = new HashMap<>();
        answMap.put("isSuccess",answ);
        return CommonResult.success(answMap);
    }

    @ApiOperation(value = "更新推荐状态")
    @RequestMapping(value = "/update/recommendStatus", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> updateRecommendSatus(@RequestBody List<Integer> ids){
        boolean answ;
        try {
            answ = productNewRecommendService.updateRecommendSatus(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        Map<String, Boolean> answMap = new HashMap<>();
        answMap.put("isSuccess",answ);
        return CommonResult.success(answMap);
    }
}
