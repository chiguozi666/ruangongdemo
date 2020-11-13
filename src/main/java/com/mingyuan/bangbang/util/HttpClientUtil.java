package com.mingyuan.bangbang.util;


import com.mingyuan.bangbang.pojo.HttpClientVo;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * httpClient工具类
 */
public class HttpClientUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    /**
     *  post请求
     * @param url 请求路径
     * @param params 请求参数
     * @return
     */
    public static HttpClientVo doPost(String url, Map<String, String> params){
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (params != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : params.keySet()) {
                    paramList.add(new BasicNameValuePair(key, params.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            int statusCode = response.getStatusLine().getStatusCode();
            HttpClientVo httpClientResult = new HttpClientVo(statusCode,resultString);

            if (null != response){
                response.close();
            }

            return httpClientResult;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("httpclient出错，请求路径："+ url + ",请求参数：" + params + ",异常：" + e);
            return null;
        }
    }

    public static HttpClientVo doGet(String url){
        HttpGet doGet = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            CloseableHttpResponse response =  httpClient.execute(doGet);
            String resultString = EntityUtils.toString(response.getEntity(), "utf-8");
            int statusCode = response.getStatusLine().getStatusCode();
            HttpClientVo vo = new HttpClientVo(statusCode,resultString);
            if (null != response){
                response.close();
            }

            JSONObject jsonObject = new JSONObject(vo);
            System.out.println(jsonObject);

            return vo;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("httpclient出错，请求路径："+ url + ",请求参数："+ ",异常：" + e);
            return null;
        }
    }
}
