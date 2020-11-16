package com.mingyuan.bangbang.service.impl;

import cn.hutool.core.lang.UUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mingyuan.bangbang.mapper.OrderMapper;
import com.mingyuan.bangbang.mapper.UserMapper;
import com.mingyuan.bangbang.pojo.OrderInfo;
import com.mingyuan.bangbang.pojo.OrderVo;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.service.OrderService;
import com.mingyuan.bangbang.util.ResultUtil;
import com.mingyuan.bangbang.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    UserMapper userMapper;
    @Override
    public ResultVo getOrderInfos(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderInfo> arrayList = orderMapper.getOrderInfos();
        return ResultUtil.successWithData(new PageInfo<OrderInfo>(arrayList));
    }

    @Override
    public ResultVo getMyPublishOrders(int pageNum, int pageSize, String token) {
        String unionid = TokenUtil.getUnionId(token);
        if(unionid==null){
            return ResultUtil.errorWithMsg("token错误，或者是用户已经被删除");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<OrderInfo> orderInfos = orderMapper.getMyPublishOrder(unionid);
        return ResultUtil.successWithData(new PageInfo<OrderInfo>(orderInfos));
    }

    @Override
    public ResultVo getMyReceiveOrders(int pageNum, int pageSize, String token) {
        String unionid = TokenUtil.getUnionId(token);
        if(unionid==null){
            return ResultUtil.errorWithMsg("token错误，或者是用户已经被删除");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<OrderInfo> orderInfos = orderMapper.getMyReceiveOrder(unionid);
        return ResultUtil.successWithData(new PageInfo<OrderInfo>(orderInfos));
    }

    @Override
    public ResultVo publishOrder(OrderVo orderVo, String token) {
        OrderInfo orderInfo = new OrderInfo();
        String unionid = TokenUtil.getUnionId(token);
        orderInfo.setPublishUserid(unionid);
        orderInfo.setReceiveUserid(null);
        //参数初始化
        orderInfo.setoMoney(new BigDecimal(orderVo.getMoney()));
        orderInfo.setLocate(orderVo.getLocate());
        orderInfo.setoPhotourl("www.xx.com.OrderServiceImpl");
        orderInfo.setoTitle(orderVo.getO_title());
        orderInfo.setoContent(orderVo.getO_content());
        //时间初始化
        long curtime = System.currentTimeMillis();
        System.out.println("orderServiceImpl当前时间:" +curtime);
        if(Long.valueOf(orderVo.getO_requiretime())<curtime){
            return ResultUtil.errorWithMsg("你的截止时间太早啦");
        }
        if(Long.valueOf(orderVo.getO_endtime())<curtime
                ||Long.valueOf(orderVo.getO_requiretime())<Long.valueOf(orderVo.getO_endtime())){
            return ResultUtil.errorWithMsg("你的截止时间太早啦,或者是截止时间大于任务完成时间");
        }
        orderInfo.setoPublishtime(String.valueOf(System.currentTimeMillis()));
        orderInfo.setoRequiretime(orderVo.getO_requiretime());
        orderInfo.setoAccepttime(null);
        orderInfo.setoEndtime(orderVo.getO_endtime());
        orderInfo.setoFintime(null);
        //状态初始化
        orderInfo.setoState(OrderInfo.START_STATE);

        orderMapper.publishOrder(orderInfo);
        return ResultUtil.successWitMsg("增加订单成功");
    }

    @Override
    public ResultVo pCancelOrder(int orderId, String token) {
        String unionid = TokenUtil.getUnionId(token);
        OrderInfo orderInfo = orderMapper.getOrderInfo(orderId);
        if(orderInfo==null)return ResultUtil.errorWithMsg("没有此订单");
        //订单号不匹配
        if(!orderInfo.getPublishUserid().equals(unionid)){
            return ResultUtil.errorWithMsg("token错误");
        }
        if(orderInfo.getoState()==OrderInfo.START_STATE){
            orderMapper.deleteOrder(orderId);
            return ResultUtil.successWitMsg("任务取消成功");
        }else {
            return ResultUtil.errorWithMsg("任务状态无法被取消");
        }
    }

    @Override
    public ResultVo rCancelOrder(String token, int orderID) {
        String unionid = TokenUtil.getUnionId(token);
        OrderInfo orderInfo = orderMapper.getOrderInfo(orderID);
        //空
        if(orderInfo==null||orderInfo.getReceiveUserid()==null)return ResultUtil.errorWithMsg("订单信息错误");
        //订单号不匹配
        if(!orderInfo.getReceiveUserid().equals(unionid)){
            return ResultUtil.errorWithMsg("token错误");
        }
        //在截止时间前1小时可以取消
        if(orderInfo.getoState()==OrderInfo.ACCEPT_RUNING_STATE&&
                Long.valueOf(orderInfo.getoEndtime())<System.currentTimeMillis()-1000*3600){
            OrderInfo result = new OrderInfo();
            orderMapper.cCancelOrder(orderID);
            return ResultUtil.successWitMsg("任务取消成功");
        }else {
            return ResultUtil.errorWithMsg("任务状态无法被取消,后续增加取消信用功能");
        }
    }

    @Override
    public ResultVo updateOrder(OrderVo orderVo, String token) {
        String unionId = TokenUtil.getUnionId(token);
        if(unionId==null){
            return ResultUtil.errorWithMsg("tocken错误");
        }
        OrderInfo orderInfo = orderMapper.getOrderInfo(orderVo.getoId());
        if(orderInfo==null){
            return ResultUtil.errorWithMsg("当前订单号不存在");
        }
        if(orderInfo.getPublishUserid()!=unionId){
            return ResultUtil.errorWithMsg("当前订单没有权限修改，请检查订单号");
        }
        if(orderInfo.getoState()!=OrderInfo.START_STATE){
            return ResultUtil.errorWithMsg("当前订单状态无法被修改(接单，或者是已完成的都不能修改)");
        }
        orderInfo.setoMoney(new BigDecimal(orderVo.getMoney()));
        orderInfo.setLocate(orderVo.getLocate());
        orderInfo.setoPhotourl("www.xx.com.OrderServiceImpl");
        orderInfo.setoTitle(orderVo.getO_title());
        orderInfo.setoContent(orderVo.getO_content());
        //时间初始化
        long curtime = System.currentTimeMillis();
        System.out.println("orderServiceImpl当前时间:" +curtime);
        if(Long.valueOf(orderVo.getO_requiretime())<curtime){
            return ResultUtil.errorWithMsg("你的截止时间太早啦");
        }
        if(Long.valueOf(orderVo.getO_endtime())<curtime
                ||Long.valueOf(orderVo.getO_requiretime())<Long.valueOf(orderVo.getO_endtime())){
            return ResultUtil.errorWithMsg("你的截止时间太早啦,或者是截止时间大于任务完成时间");
        }
        orderInfo.setoPublishtime(String.valueOf(System.currentTimeMillis()));
        orderInfo.setoRequiretime(orderVo.getO_requiretime());
        orderInfo.setoAccepttime(null);
        orderInfo.setoEndtime(orderVo.getO_endtime());
        orderInfo.setoFintime(null);
        orderMapper.updateOrder(orderInfo);
        return null;
    }

    @Override
    public ResultVo receiveOrder(String token, int orderID) {
        String unionId = TokenUtil.getUnionId(token);
        OrderInfo orderInfo = orderMapper.getOrderInfo(orderID);
        if(orderInfo==null){
            return ResultUtil.errorWithMsg("订单信息错误");
        }
        if(Long.valueOf(orderInfo.getoRequiretime())<System.currentTimeMillis()){
            orderInfo.setoState(OrderInfo.START_OVER_ACCEPT_TIME_STATE);
            return ResultUtil.successWitMsg("当前任务已经超出限定时间了，不能被你接取了");
        }
        //接收成功
        if(orderInfo.getoState()==OrderInfo.START_STATE){
            orderInfo.setReceiveUserid(unionId);
            orderInfo.setoState(OrderInfo.ACCEPT_RUNING_STATE);
            orderMapper.updateOrder(orderInfo);
            return ResultUtil.successWitMsg("接收成功！");
        }
        return ResultUtil.errorWithMsg("订单状态不能被接收，靴靴");
    }

    @Override
    public ResultVo completeOrder(String token, int orderId) {
        String unionId = TokenUtil.getUnionId(token);
        OrderInfo orderInfo = orderMapper.getOrderInfo(orderId);
        if(orderInfo==null){
            return ResultUtil.errorWithMsg("订单信息错误");
        }
        if(!orderInfo.getReceiveUserid().equals(unionId)){
            return ResultUtil.errorWithMsg("token信息错误");
        }
        Long time = System.currentTimeMillis();
        orderInfo.setoFintime(String.valueOf(time));
        if(orderInfo.getoState()!=OrderInfo.ACCEPT_RUNING_STATE||orderInfo.getoState()!=OrderInfo.ACCEPT_RUNING_STATE){
            return ResultUtil.errorWithMsg("当前任务状态不能被完成,仅仅支持ACCEPT_RUNING_STATE");
        }
        if(time>Long.valueOf(orderInfo.getoRequiretime())){
            // TODO: 2020/11/16 信用的修改
            orderInfo.setoState(OrderInfo.FINISH_BUT_OVERTIME_STATE);
            orderMapper.updateOrder(orderInfo);
            return ResultUtil.successWitMsg("提交成功，但是你这次超时了");
        }else {
            orderInfo.setoState(OrderInfo.FINISH_NORMAL_STATE);
            orderMapper.updateOrder(orderInfo);
            return ResultUtil.successWitMsg("提交成功");
        }

    }
}
