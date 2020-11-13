package com.mingyuan.bangbang;

import com.mingyuan.bangbang.pojo.UserInfo;
import com.mingyuan.bangbang.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BangbangApplication.class)
@EnableAutoConfiguration
public class TestRedis {
    @Autowired
    private ValueOperations valueOperations;
    @Test
    public void redisconnect(){

    }
    @Test
    public void rediscontest(){
        RedisUtil.setToken(valueOperations,"1060020877.unionid.234");
        String userInfo = RedisUtil.getToken(valueOperations,"1060020877.chiguoguo.234");
        System.out.println(userInfo);
    }
}
