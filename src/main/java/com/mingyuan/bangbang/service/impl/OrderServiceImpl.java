package com.mingyuan.bangbang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mingyuan.bangbang.mapper.OrderMapper;
import com.mingyuan.bangbang.mapper.UserMapper;
import com.mingyuan.bangbang.pojo.OrderInfo;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.service.OrderService;
import com.mingyuan.bangbang.util.ResultUtil;
import com.mingyuan.bangbang.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public ResultVo getMyOrderInfos(String token) {
        String unionId = TokenUtil.getUnionId(token);
        if(unionId==null||userMapper.getUserInfo(unionId)==null){
            return ResultUtil.errorWithMsg("token错误");
        }

        return null;
    }

    @Override
    public ResultVo insertOrderInfo(OrderInfo orderInfo, String token) {
        return null;
    }

    @Override
    public ResultVo deleteOrderInfo(String token, int orderID) {
        return null;
    }

    @Override
    public ResultVo updateOrderInfo(String token, int orderId) {
        return null;
    }
}
