package com.mingyuan.bangbang.service;

import com.mingyuan.bangbang.pojo.OrderInfo;
import com.mingyuan.bangbang.pojo.OrderVo;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.pojo.UserInfo;

import java.util.ArrayList;

public interface OrderService {
    public ResultVo getOrderInfos(int pageNum,int pageSize);
    public ResultVo getMyPublishOrders(int pageNum,int pageSize,String token);
    public ResultVo getMyReceiveOrders(int pageNum,int pageSize,String token);
    public ResultVo publishOrder(OrderVo orderVo, String token);
    //发布者取消订单
    public ResultVo pCancelOrder(int orderId, String token);
    //发布者更新订单
    public ResultVo updateOrder(OrderVo orderVo,String token);
    //接受者接收订单
    public ResultVo receiveOrder(String token,int orderID);
    //接受者接收订单
    public ResultVo rCancelOrder(String token,int orderID);
    //接受者完成订单
    public ResultVo completeOrder(String token,int orderId);
}
