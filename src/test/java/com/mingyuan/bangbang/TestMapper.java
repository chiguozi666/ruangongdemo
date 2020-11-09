package com.mingyuan.bangbang;

import com.mingyuan.bangbang.mapper.OrderMapper;
import com.mingyuan.bangbang.pojo.OrderInfo;
import org.apache.ibatis.session.SqlSession;
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
}
