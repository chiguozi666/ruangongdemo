package com.mingyuan.bangbang;

import com.mingyuan.bangbang.mapper.CreditHistoryMapper;
import com.mingyuan.bangbang.mapper.OrderMapper;
import com.mingyuan.bangbang.pojo.CreditHistory;
import com.mingyuan.bangbang.pojo.OrderInfo;
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
    OrderMapper orderMapper;
    @Resource
    CreditHistoryMapper creditHistoryMapper;

    @Test
    public void testInsert(){
        OrderInfo orderInfo = OrderInfo.getTestInstance();
        orderMapper.insertOrderInfo(orderInfo);
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
}
