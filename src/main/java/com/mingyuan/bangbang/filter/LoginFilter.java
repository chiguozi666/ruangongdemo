package com.mingyuan.bangbang.filter;


import cn.hutool.core.util.URLUtil;
import com.mingyuan.bangbang.mapper.UserMapper;
import com.mingyuan.bangbang.pojo.ResultVo;
import com.mingyuan.bangbang.util.RedisUtil;
import com.mingyuan.bangbang.util.ResultUtil;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 登录控制过滤器
 */
//implements Filter
public class LoginFilter implements Filter{

    private HashOperations hashOperations;
    private ValueOperations valueOperations;
    private static List<String> passUrls = new ArrayList<>();//不用登录即可以访问的url
    @Autowired
    UserMapper userMapper;
    static {
        passUrls.add("/user/login");//登录

        passUrls.add("/swagger-ui.html/**");//swagger
        passUrls.add("/swagger-resources/**");//
        passUrls.add("/swagger/**");
        passUrls.add("/**/v2/api-docs");
        passUrls.add("/**/*.js");
        passUrls.add("/**/*.css");
        passUrls.add("/actuator/**");
        passUrls.add("/webjars/springfox-swagger-ui/**");
        passUrls.add("/swagger-ui.html#");
        passUrls.add("/**/*.ico");
        passUrls.add("/**/*.png");
    }

    @Override
    public void init(FilterConfig filterConfig) {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        hashOperations = context.getBean(HashOperations.class);
        valueOperations = context.getBean(ValueOperations.class);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //跨域请求，*代表允许全部类型
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
        //允许请求方式
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        //用来指定本次预检请求的有效期，单位为秒，在此期间不用发出另一条预检请求
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        //请求包含的字段内容，如有多个可用哪个逗号分隔如下
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,Authorization, x-ui-request,lang");
        //访问控制允许凭据，true为允许
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        // 浏览器是会先发一次options请求，如果请求通过，则继续发送正式的post请求
        // 配置options的请求返回
        if (httpServletRequest.getMethod().equals("OPTIONS")) {
            httpServletResponse.setStatus(HttpStatus.SC_OK);
            httpServletResponse.getWriter().write("OPTIONS returns OK");
            return;
        }
        String requestURI = httpServletRequest.getRequestURI();
        String path = URLUtil.getPath(requestURI);
        System.out.println(httpServletRequest.getHeader("token"));
        RedisUtil.getUnionId(valueOperations,httpServletRequest.getHeader("token"));//存在则更新redis过期时间
        if(path.startsWith("/null")){
            path = path.substring(5);
        }
        for (String str : passUrls){
            AntPathMatcher antPathMatcher = new AntPathMatcher();
            if ( antPathMatcher.match(str, path)) {
                filterChain.doFilter(httpServletRequest,httpServletResponse);
                return;
            }
        }
        String token = httpServletRequest.getHeader("token");
        String unionid = RedisUtil.getUnionId(valueOperations, token);
        if (unionid==null){
            needLoginResponse( httpServletResponse,"未登录,请携带token");
        }else if(userMapper.getUserInfo(unionid).getuStudentnum()==null){
            needLoginResponse( httpServletResponse,"登录成功，请去register填写完整的信息");
        } else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);//放行
        }
    }

    private void needLoginResponse(HttpServletResponse httpServletResponse, String msg) throws IOException {
        ResultVo resultVo = ResultUtil.UNAUTHORIZED(msg);
        JSONObject jsonObject = new JSONObject(resultVo);
        jsonObject.remove("success");
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.getOutputStream().write(jsonObject.toString().getBytes("UTF-8"));
        httpServletResponse.getOutputStream().flush();
        httpServletResponse.getOutputStream().close();
    }

}
