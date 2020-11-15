package com.mingyuan.bangbang;

import com.github.pagehelper.PageInfo;
import com.mingyuan.bangbang.mapper.UserMapper;
import com.mingyuan.bangbang.pojo.OrderInfo;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.pojo.UserInfo;
import com.mingyuan.bangbang.service.OrderService;
import com.mingyuan.bangbang.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BangbangApplication.class)
@EnableAutoConfiguration
public class BangbangApplicationTests {
    @Resource
    UserMapper userMapper;
    @Resource
    OrderService orderServiceImpl;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testUserMapper(){
        System.out.println(userMapper.getUserInfos());
//        UserInfo userInfo = new UserInfo();
//        userInfo.setOpenid("oppenid");
//        userInfo.setSessionkey("sessionmonkey");
//        userInfo.setUnionid("unionid1");
//        userInfo.setuCredit(100);
//        userInfo.setuStudentnum("311800");
//        userInfo.setuName("chiguozi");
//        userInfo.setuPhone("1234567890");
//        userInfo.setuIdentify("440181000000000");
//        //userMapper.insertUserInfo(userInfo);
//        System.out.println(userMapper.getUserInfos());
//        userInfo.setUnionid("unionid");
//        userMapper.updateUser(userInfo);
        UserInfo userInfo = userMapper.getUserInfo("chiguozi");
        System.out.println(userInfo);
        //userMapper.deleteUser("unionid1");
    }
    @Test
    public void testSpiltPage(){
        ResultVo resultVo = orderServiceImpl.getOrderInfos(4,3);
        System.out.println(resultVo);
    }

}
