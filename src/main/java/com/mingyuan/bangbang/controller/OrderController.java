package com.mingyuan.bangbang.controller;

import com.mingyuan.bangbang.pojo.OrderInfo;
import com.mingyuan.bangbang.pojo.OrderVo;
import com.mingyuan.bangbang.pojo.PageVo;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.service.OrderService;
import com.mingyuan.bangbang.service.UserService;
import com.mingyuan.bangbang.util.ResultUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

@RestController
@ApiModel(value="和订单有关的操作",description="" )
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderService orderServiceImpl;
    @GetMapping(value = "/show")
    public ResultVo getOrders(int pageNum,int pageSize){
        //@ApiParam(name="页面大小",required=true,value="页面大小")

        return orderServiceImpl.getOrderInfos(pageNum,pageSize);
    }
    @ApiParam(value = "提供我发布的任务列表")
    @PostMapping(value = "/myPublishOrder/show")
    public ResultVo getMyPublishOrders(@ApiParam(name="页面的参数pageNum是页数,pageSize是页面大小",required=true,value="页面的参数pageNum是页数,pageSize是页面大小")@RequestBody PageVo pageVo,
                                       @RequestHeader(required = true) String token){
        if(pageVo==null)return ResultUtil.errorWithMsg("传入参数失败");
        return orderServiceImpl.getMyPublishOrders(pageVo.getPageNum(),pageVo.getPageSize(),token);
    }
    @ApiParam(value = "提供我发布的任务列表")
    @PostMapping(value = "/myReceiveOrder/show")
    public ResultVo getMyReceiveOrders(@ApiParam(name="页面的参数pageNum是页数,pageSize是页面大小",required=true,value="页面的参数pageNum是页数,pageSize是页面大小")@RequestBody PageVo pageVo,
                                       @RequestHeader(required = true) String token){
        return orderServiceImpl.getMyReceiveOrders(pageVo.getPageNum(),pageVo.getPageSize(),token);
    }
    @ApiParam(value = "发布任务")
    @PostMapping(value = "/publish")
    public ResultVo publishOrder(@ApiParam(name="传入对象",value="orderInfo",required=true)@RequestBody OrderVo orderVo,
                                @RequestHeader(required = true) String token) {
        return orderServiceImpl.publishOrder(orderVo, token);
    }
    @ApiParam(value = "用户接收任务")
    @PostMapping(value = "/accept")
    public ResultVo receiveOrder(@ApiParam(name="订单号",value="orderId",required=true)@RequestBody int orderId,
                                @RequestHeader(required = true) String token) {
        return orderServiceImpl.receiveOrder(token,orderId);
    }
    @ApiParam(value = "接受者完成任务")
    @PostMapping(value = "/fin")
    public ResultVo finOrder(@ApiParam(name="订单号",value="orderId",required=true)@RequestBody int orderId,
                                 @RequestHeader(required = true) String token) {
        return orderServiceImpl.completeOrder(token,orderId);
    }
    @ApiParam(value = "发布者取消订单")
    @PostMapping(value = "/pCancelOrder")
    public ResultVo pCancelOrder(@ApiParam(name="订单号",value="orderId",required=true)@RequestBody int orderId,
                             @RequestHeader(required = true) String token) {
        return orderServiceImpl.pCancelOrder(orderId,token);
    }
    @ApiParam(value = "接收者取消订单")
    @PostMapping(value = "/rCancelOrder")
    public ResultVo rCancelOrder(@ApiParam(name="订单号",value="orderId",required=true)@RequestBody int orderId,
                                 @RequestHeader(required = true) String token) {
        return orderServiceImpl.rCancelOrder(token,orderId);
    }

}
