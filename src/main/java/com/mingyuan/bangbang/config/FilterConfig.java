package com.mingyuan.bangbang.config;


import com.mingyuan.bangbang.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册filter
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilterRegistration() {
        //创建filter
        LoginFilter loginFilter = new LoginFilter();
        //注册过滤器
        FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<>(loginFilter);
        registration.setFilter(loginFilter);
        //添加条件
        registration.addUrlPatterns("/apple");
        return registration;
    }

    /**
     * 多个过滤器只需要重写多个方法
     * @return
     */
}
