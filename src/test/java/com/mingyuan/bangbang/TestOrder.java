package com.mingyuan.bangbang;

import com.mingyuan.bangbang.mapper.OrderMapper;
import com.mingyuan.bangbang.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BangbangApplication.class)
@EnableAutoConfiguration
public class TestOrder {
    @Resource
    OrderMapper orderMapper;
    @Resource
    OrderService orderServiceImpl;
    @Test
    public void TestGetOrder(){
        System.out.println(orderServiceImpl.getMyPublishOrders(3,2,"cc.unionid.cc"));
        System.out.println(orderServiceImpl.getMyReceiveOrders(3,2,"cc.unionid.cc"));
    }
}
