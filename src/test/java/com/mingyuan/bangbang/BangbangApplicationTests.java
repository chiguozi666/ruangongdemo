package com.mingyuan.bangbang;

import com.mingyuan.bangbang.mapper.UserMapper;
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
public class BangbangApplicationTests {
    @Resource
    UserMapper userMapper;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testUserMapper(){
        System.out.println(userMapper.getUserInfos());
        UserInfo userInfo = new UserInfo();
        userInfo.setOpenid("oppenid");
        userInfo.setSessionkey("sessionmonkey");
        userInfo.setUnionid("unionid1");
        userInfo.setuCredit(100);
        userInfo.setuStudentnum("311800");
        userInfo.setuName("chiguozi");
        userInfo.setuPhone(1234567890);
        userInfo.setuIdentify("440181000000000");
        //userMapper.insertUserInfo(userInfo);
        System.out.println(userMapper.getUserInfos());
        userInfo.setUnionid("unionid");
        userMapper.updateUser(userInfo);
        //userMapper.deleteUser("unionid1");
    }

}
