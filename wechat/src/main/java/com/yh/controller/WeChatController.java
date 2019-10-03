package com.yh.controller;

import com.yh.commons.WeChatCommon;
import com.yh.domain.WxUser;
import com.yh.service.WxUserService;
import com.yh.utils.EncryptUtil;
import com.yh.utils.WeChatUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class WeChatController {
    @Resource(name = "wxUserServiceImpl")
    WxUserService wxUserService;

    /***
     * 微信平台验证服务器
     * @param weChatCommon
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String verifyWeChat(WeChatCommon weChatCommon) {
        if (weChatCommon == null) {
            return "no";
        }
        boolean result = WeChatUtil.checkSignature(weChatCommon);
        if (result) {
            return weChatCommon.getEchostr();
        }
        return "";
    }

    /***
     * 用户与服务器交互
     * @param request
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.POST)
    public String msgManager(HttpServletRequest request, HttpSession session) {
        return WeChatUtil.msgManager(request,session);
    }

    @RequestMapping(value = "code",method = RequestMethod.POST)
    public String dealCode(HttpServletRequest request,HttpSession httpSession){
        Map<String,String> map=WeChatUtil.getAccreditAccessToken(request);
        WxUser wxUser=WeChatUtil.getUserInfoByAccredit(map.get("access_token"),map.get("openid"));
        WxUser d_wxUser=wxUserService.selectUserByOpenId(wxUser.getOpenid());
        if(d_wxUser==null){
            wxUserService.insertNewUser(wxUser);
            d_wxUser=wxUser;
        }else {
            d_wxUser=wxUserService.selectUserByOpenId(wxUser.getOpenid());
        }
        httpSession.setAttribute("d_wxUser",d_wxUser);
        return "";
    }

    @RequestMapping(value = "config")
    public Map<String,String> wxJsConfig(HttpServletRequest request){
        Map<String,String> map=new HashMap<>();
        map.put("appId",WeChatUtil.APPID);
        map.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        map.put("nonceStr", UUID.randomUUID().toString().replaceAll("-",""));
        String str="jsapi_ticket="+WeChatUtil.getJsApiTicket()+"&noncestr="+map.get("nonceStr")+"&timestamp="+map.get("timestamp")+"&url="+request.getParameter("url");
        map.put("signature",EncryptUtil.getSha1(str));
        return map;
    }
    @RequestMapping(value = "getshare")
    public Map<String,Object> shareConfig(HttpSession session){
        System.out.println((WxUser)session.getAttribute("d_wxUser"));
        int wxId=((WxUser)session.getAttribute("d_wxUser")).getId();
        Map<String,Object> map=new HashMap<>();
        Map<String,String> appMessages=new HashMap<>();
        appMessages.put("title","hahah");
        appMessages.put("desc","猪八戒");
        appMessages.put("link","http://jusavng.hn3.mofasuidao.cn/app/sweep_code.html?ticket="+WeChatUtil.getQRcode(wxId));
        appMessages.put("imgUrl","http://jusavng.hn3.mofasuidao.cn/app/images/del-pic.jpg");
        Map<String,String> timeline=new HashMap<>();
        timeline.put("title","朋友圈");
        timeline.put("link","http://jusavng.hn3.mofasuidao.cn/app/sweep_code.html?ticket="+WeChatUtil.getQRcode(wxId));
        timeline.put("imgUrl","http://jusavng.hn3.mofasuidao.cn/app/images/del-pic.jpg");
        map.put("appMessages",appMessages);
        map.put("timeline",timeline);
        return  map;
    }
}
