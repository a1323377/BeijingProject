package com.yh.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EncryptUtil {

    public static String getSha1(String str) {

        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(str.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
    public static String encodingUrl(String url){
        try {
            return  URLEncoder.encode(url,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 去除重复的商品信息，保证集合中每个商品信息都不同
     * @param list
     * @return
     */
    public static List<Map<String,String>> distinctList(List<Map<String,String>> list){
        List<Map<String,String>> newList=new ArrayList<>();
        String name="";
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).get("productName"));
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).get("productName").equals(name)==false){
                newList.add(list.get(i));
            }
            name=list.get(i).get("productName");
        }
        for(int i=0;i<newList.size();i++){
            System.out.println(newList.get(i).get("productName"));
        }
        return newList;
    }
}
