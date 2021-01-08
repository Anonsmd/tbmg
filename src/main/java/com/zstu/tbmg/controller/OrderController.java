package com.zstu.tbmg.controller;

import com.zstu.tbmg.api.CommonResult;
import com.zstu.tbmg.dto.BrandListDTO;
import com.zstu.tbmg.dto.OrderDTO;
import com.zstu.tbmg.dto.OrderMasterListDTO;
import com.zstu.tbmg.dto.ShippingUpdateDTO;
import com.zstu.tbmg.pojo.OrderShippingInfo;
import com.zstu.tbmg.service.OrderMasterService;
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
import java.util.Map;

/**
 * @Author: Anonsmd
 * @Date: 2021/1/7 20:34
 */
@Controller
@Api(tags = "OrderController", description = "订单管理")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderMasterService orderMasterService;
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

    @ApiOperation(value = "获取订单列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getList(@RequestParam(value="pageNum")int pageNum, @RequestParam(value="pageSize")int pageSize,
                                                      @RequestParam(value="orderSn",required = false)Long orderSn,
                                                      @RequestParam(value="loginName",required = false)String loginName,
                                                      @RequestParam(value="orderStatus",required = false)Byte orderStatus,
                                                      @RequestParam(value="paymentMethod",required = false)Byte paymentMethod

    ){
        OrderMasterListDTO answ;
        try {
            answ = orderMasterService.getList(pageNum,pageSize,orderSn,loginName,orderStatus,paymentMethod);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }

    @ApiOperation(value = "获取订单列表")
    @RequestMapping(value = "/getShippingInfo", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getList(@RequestParam(value="orderId")Integer orderId){
        OrderShippingInfo answ;
        try {
            answ = orderMasterService.getShipingInfoByOrderSn(orderId);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }

    @ApiOperation(value = "更新物流信息")
    @RequestMapping(value = "/update/delivery", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> updateShippingInfo(@RequestBody ShippingUpdateDTO shippingUpdateDTO){
        boolean answ;
        try {
            answ = orderMasterService.updateShippingInfo(shippingUpdateDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        Map<String, Boolean> answMap = new HashMap<>();
        answMap.put("isSuccess",answ);
        return CommonResult.success(answMap);
    }

    @ApiOperation(value = "获取订单具体信息")
    @RequestMapping(value = "/getDetailInfo/{orderDTO}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> getDetailInfo(@PathVariable Integer orderDTO){
        OrderDTO answ;
        try {
            answ = orderMasterService.getDetailInfo(orderDTO);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success(answ);
    }
}
