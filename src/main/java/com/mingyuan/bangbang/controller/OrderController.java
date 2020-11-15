package com.mingyuan.bangbang.controller;

import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.service.OrderService;
import com.mingyuan.bangbang.service.UserService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@ApiModel(value="和订单有关的操作",description="" )
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    OrderService orderServiceImpl;
    @GetMapping(value = "/show")
    private ResultVo getOrders(@ApiParam(name="第几页",required=true,value="第几页")int pageNum,@ApiParam(name="页面大小",required=true,value="第几页") int pageSize){
        return orderServiceImpl.getOrderInfos(pageNum,pageSize);
    }
    @ApiParam(value = "提供我发布的任务")
    @PostMapping(value = "/myPublishOrder/show")
    private ResultVo getMyOrders(@ApiParam(name="第几页",required=true,value="第几页")int pageNum,@ApiParam(name="页面大小",required=true,value="第几页") int pageSize,@RequestHeader(required = true) String token){

        return orderServiceImpl.getOrderInfos();
    }
//    @GetMapping(value = "/showMyPublishOrders"){
//
//    }
}
