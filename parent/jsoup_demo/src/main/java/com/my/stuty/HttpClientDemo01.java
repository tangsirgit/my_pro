package com.my.stuty;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * HttpClient的demo01
 *
 * @author : tanghuai
 * @date : 2021/3/1 15:42
 */
public class HttpClientDemo01 {
    public static void main(String[] args) throws IOException {
        // 1 打开浏览器,创建httpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 2 输入网址 发起get请求，创建httpGet对象
        HttpGet get = new HttpGet("https://www.baidu.com/");

        // 3 按回车 发起请求 得到响应
        CloseableHttpResponse execute = httpClient.execute(get);
        // 4 解析响应
        // 判读状态码是否正常
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = execute.getEntity();
            String content = EntityUtils.toString(entity, "utf8");
            System.out.println(content);
        }
    }

}
