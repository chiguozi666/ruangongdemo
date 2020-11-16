package com.mingyuan.bangbang.service.impl;

import com.mingyuan.bangbang.mapper.CreditHistoryMapper;
import com.mingyuan.bangbang.mapper.OrderMapper;
import com.mingyuan.bangbang.mapper.UserMapper;
import com.mingyuan.bangbang.pojo.CreditHistory;
import com.mingyuan.bangbang.pojo.OrderInfo;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.pojo.UserInfo;
import com.mingyuan.bangbang.service.CreditService;
import com.mingyuan.bangbang.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditServiceImpl implements CreditService {
    @Autowired
    public CreditHistoryMapper creditHistoryMapper;
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public OrderMapper orderMapper;
    @Override
    // TODO: 2020/11/16 要开始事务
    public ResultVo createCredit(CreditHistory creditHistory){
        int oId = creditHistory.getoId();
        String unionId = creditHistory.getUnionid();
        OrderInfo orderInfo = orderMapper.getOrderInfo(oId);
        UserInfo userInfo = userMapper.getUserInfo(unionId);
        if(orderInfo==null){
            return ResultUtil.errorWithMsg("信用历史创建：订单号错误");
        }
        if(userInfo==null){
            return ResultUtil.errorWithMsg("信用历史创建：没有此用户");
        }
        //更新信用
        userInfo.setuCredit(userInfo.getuCredit()-creditHistory.getChCreditChange());
        userMapper.updateUser(userInfo);
        creditHistoryMapper.insertCreditHistory(creditHistory);
        return ResultUtil.successWitMsg("创建信用历史记录成功");
    }
}
