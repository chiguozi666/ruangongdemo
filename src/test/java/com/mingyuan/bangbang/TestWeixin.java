package com.mingyuan.bangbang;

import com.mingyuan.bangbang.config.WeixinConfig;
import com.mingyuan.bangbang.pojo.HttpClientVo;
import com.mingyuan.bangbang.service.UserService;
import com.mingyuan.bangbang.util.HttpClientUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BangbangApplication.class)
@ConfigurationPropertiesScan(basePackages = "com.mingyuan.bangbang.config")
@EnableAutoConfiguration
public class TestWeixin {
    @Autowired
    public WeixinConfig weixinConfig;
    @Autowired
    public UserService loginServiceImpl;
    @Test
    public void testWeixinConfig(){
        System.out.println(weixinConfig);
    }
    @Test
    public void testLogin(){

        //String result = loginServiceImpl.login("xxx","063h7gll2SOQW54nTjnl25TEQ60h7glt");
        //System.out.println(result);
        return;
    }
    @Test
    public void testHttpUtil(){
        HttpClientVo clientVo = HttpClientUtil.doGet("https://www.baidu.com");
        System.out.println(clientVo);
    }
}
