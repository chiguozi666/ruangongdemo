package com.mingyuan.bangbang.util;

import java.text.ParseException;
import java.util.Date;

import com.nimbusds.jose.*;


import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.Random;


public class TokenUtil {
    public static String createToken(String sessionkey,String unionid,String openid){
        Random random = new Random();
        String token = (random.nextInt(80000)+10000)+"."+unionid+"."+(random.nextInt(80000)+10000);
        System.out.println(token);
        return token;
    }

    public static void main(String[] args) {
        String s= createToken("","123","");
        System.out.println(s);
    }

}