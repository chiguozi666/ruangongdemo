package com.mingyuan.bangbang;

import com.mingyuan.bangbang.mapper.CreditHistoryMapper;
import com.mingyuan.bangbang.mapper.OrderMapper;
import com.mingyuan.bangbang.mapper.UserMapper;
import com.mingyuan.bangbang.pojo.CreditHistory;
import com.mingyuan.bangbang.pojo.OrderInfo;
import com.mingyuan.bangbang.pojo.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BangbangApplication.class)
@EnableAutoConfiguration
public class TestMapper {
    @Resource
    UserMapper userMapper;
    @Resource
    OrderMapper orderMapper;
    @Resource
    CreditHistoryMapper creditHistoryMapper;

    @Test
    public void testInsert(){
        UserInfo userInfo;
        userInfo = new UserInfo();
        userInfo.setUnionid("uhonguouo");
        userInfo.setOpenid("oppenid");
        userInfo.setSessionkey("session_key");
        userMapper.insertUserInfo(userInfo);

    }
    @Test
    public void testUpdate(){
        OrderInfo orderInfo = OrderInfo.getTestInstance();
        orderInfo.setoId(1);
        orderInfo.setLocate("家里");
        orderMapper.updateOrder(orderInfo);
        System.out.println(orderInfo);
    }
    @Test
    public void testDelete(){
        OrderInfo orderInfo = OrderInfo.getTestInstance();
        orderInfo.setoId(3);
        orderMapper.deleteOrder(3);
    }
    @Test
    public void testSelete(){
        System.out.println(orderMapper.getOrderInfos());
    }

    @Test
    public void testCreditHistory(){
        CreditHistory creditHistory = CreditHistory.getTestInstance();
        creditHistory.setChId(1);
        creditHistory.setChReason("嘻嘻嘻");
        creditHistoryMapper.updateCreditHistory(creditHistory);
        System.out.println(creditHistoryMapper.getCreditHistories());
    }
    @Test
    public void testInsertOrder(){
            OrderInfo orderInfo = OrderInfo.getTestInstance();
            orderMapper.publishOrder(orderInfo);

    }
}
