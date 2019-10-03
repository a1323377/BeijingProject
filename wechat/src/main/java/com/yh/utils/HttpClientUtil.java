package com.yh.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


public class HttpClientUtil {

    /***
     * 发送http请求，返回json对象
     * @param httpRequestBase
     * @return
     */
    private static JSONObject getJsonObject(HttpRequestBase httpRequestBase) {
        HttpClient httpClient=new DefaultHttpClient();
        JSONObject jsonObject = null;
        try {
            HttpResponse httpResponse =httpClient.execute(httpRequestBase) ;
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                jsonObject = new JSONObject(EntityUtils.toString(httpResponse.getEntity(),"utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * get方式请求url
     * @param url
     * @return
     */
    public static JSONObject doGet(String url){
        HttpGet httpGet=new HttpGet(url);
        JSONObject jsonObject = getJsonObject(httpGet);
        return  jsonObject;
    }

    /**
     * post方式请求url
     * @param url
     * @param data
     * @return
     */
    public static JSONObject doPost(String url,String data){
        HttpPost httpPost=new HttpPost(url);
        httpPost.setEntity(new StringEntity(data,"utf-8"));
        JSONObject jsonObject = getJsonObject(httpPost);
        return jsonObject;
    }
}
