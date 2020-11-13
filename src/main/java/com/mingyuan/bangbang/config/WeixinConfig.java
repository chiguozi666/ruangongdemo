package com.mingyuan.bangbang.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wx")
public class WeixinConfig {
    private String appid;
    private String appsecret;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    @Override
    public String toString() {
        return "WeixinConfig{" +
                "appid='" + appid + '\'' +
                ", appsecret='" + appsecret + '\'' +
                '}';
    }
}
