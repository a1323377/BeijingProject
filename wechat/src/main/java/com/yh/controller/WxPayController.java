package com.yh.controller;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import com.yh.commons.MyConfig;
import com.yh.commons.ResponseJson;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WxPayController {

    @RequestMapping(value = "getqrcode")
    public ResponseJson getQrCode() throws Exception {
        WXPay wxPay =new WXPay(new MyConfig());
        Map<String,String> map=new HashMap<>();
        map.put("body","扫码支付测试");
        map.put("out_trade_no","201619160111");
        map.put("total_fee","1");
        map.put("spbill_create_ip","123.12.12.123");
        map.put("notify_url","http://jusavng.hn3.mofasuidao.cn/wechat/notifyUrl.do");
        map.put("trade_type","NATIVE");
        Map<String,String> map1=wxPay.unifiedOrder(map);
        String codeUrl="";
        System.out.println(map1.toString());
        if(map1.get("return_code").equals("SUCCESS")&&map1.get("result_code").equals("SUCCESS")){
            codeUrl=map1.get("code_url");
        }
        return new ResponseJson(0,"success",codeUrl);
    }
    @RequestMapping(value = "notifyUrl")
    public String notifyUrl(HttpServletRequest request) throws Exception {
        Document build = new SAXBuilder().build(request.getInputStream());
        Element rootElement = build.getRootElement();
        String total_fee = rootElement.getChildText("total_fee");
        String out_trade_no = rootElement.getChildText("out_trade_no");
        System.out.println(total_fee);
        System.out.println(out_trade_no);
        Map<String,String> map=new HashMap<>();
        map.put("return_code","SUCCESS");
        map.put("return_msg","OK");
        String xml = WXPayUtil.mapToXml(map);
        return xml;
    }
}
