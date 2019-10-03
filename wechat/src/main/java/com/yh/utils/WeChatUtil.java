package com.yh.utils;

import com.yh.commons.WeChatCommon;
import com.yh.domain.Message;
import com.yh.domain.QrCode;
import com.yh.domain.QrUserGroup;
import com.yh.domain.WxUser;
import com.yh.service.*;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

public class WeChatUtil {
    public static final String APPID="wxb87b46429089c0f1";
    public static final String APPSECRET="9804349cc7dbab4f98db37e3ae7336ae";
    public static String ACCESS_TOKEN=null;
    public static long ACCESS_TOKEN_TIME=0L;
    //public static String ACCREDIT_ACCESS_TOKEN=null;
    //public static long ACCREDIT_ACCESS_TOKEN_TIME=0L;
    /**
     * 验证微信服务器
     * @param weChatCommon
     * @return
     */
    public static boolean checkSignature(WeChatCommon weChatCommon){
        List<String> list=new ArrayList<>();
        list.add(weChatCommon.getNonce());
        list.add(weChatCommon.getTimestamp());
        list.add(weChatCommon.getToken());
        Collections.sort(list);
        String str="";
        for (String s : list) {
            str+=s;
        }
        String sha1Str=EncryptUtil.getSha1(str);
        if(sha1Str.equals(weChatCommon.getSignature())){
            return true;
        }
        return false;
    }

    /**
     * 获取access_token
     * @return
     */
    private static String getAccessToken(){
        long now=System.currentTimeMillis()/1000;
        if(ACCESS_TOKEN==null||now-ACCESS_TOKEN_TIME>7200){
            String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;
            ACCESS_TOKEN=HttpClientUtil.doGet(url).get("access_token").toString();
            ACCESS_TOKEN_TIME=System.currentTimeMillis()/1000;
        }
        return ACCESS_TOKEN;
    }

    /**
     * 获取页面授权access_token和openid
     * @param request
     * @return
     */
    public static Map<String,String> getAccreditAccessToken(HttpServletRequest request){
        String code=request.getParameter("code");
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+APPSECRET+"&code="+code+"&grant_type=authorization_code";
        JSONObject jsonObject=HttpClientUtil.doGet(url);
        Map<String,String> map=new HashMap<>();
        map.put("access_token",jsonObject.get("access_token").toString());
        map.put("openid",jsonObject.get("openid").toString());
        return  map;
    }

    /**
     * 创建菜单
     */
    public static void createMenu(){
        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+getAccessToken();
        JSONObject big=new JSONObject();
        JSONArray first=new JSONArray();
        JSONObject menua=new JSONObject();
        menua.put("name","首页");
        menua.put("type","view");
        menua.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WeChatUtil.APPID+"&redirect_uri="+EncryptUtil.encodingUrl("http://jusavng.hn3.mofasuidao.cn/app/index.html")+"?&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        first.put(menua);
        JSONObject menub=new JSONObject();
        menub.put("name","购物车");
        menub.put("type","view");
        menub.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid=\"+WeChatUtil.APPID+\"&redirect_uri=\"+EncryptUtil.encodingUrl(\"http://jusavng.hn3.mofasuidao.cn/app/shopcar.html\")+\"?&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        first.put(menub);
        JSONObject menuc=new JSONObject();
        menuc.put("name","个人中心");
        menuc.put("type","view");
        menuc.put("url","https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WeChatUtil.APPID+"&redirect_uri="+EncryptUtil.encodingUrl("http://jusavng.hn3.mofasuidao.cn/app/pcenter.html")+"?&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
        first.put(menuc);
        big.put("button",first);
        HttpClientUtil.doPost(url,big.toString());
    }

    /**
     * 通过网页授权的方式获得用户信息
     * @return
     */
    public static WxUser getUserInfoByAccredit(String accessToken,String openid){
        String url="https://api.weixin.qq.com/sns/userinfo?access_token="+accessToken+"&openid="+openid+"&lang=zh_CN";
        return  JsonUtil.fromJson(HttpClientUtil.doGet(url).toString(),WxUser.class);
    }
    /**
     * 获取微信用户信息
     * @param document
     * @return
     */
    private static WxUser getUserInfo(Document document){
        String url="https://api.weixin.qq.com/cgi-bin/user/info?access_token="+WeChatUtil.getAccessToken()+"&openid="+XmlUtil.getMsgXmlText(document,"FromUserName")+"&lang=zh_CN";
        JSONObject jsonObjec=HttpClientUtil.doGet(url);
        WxUser wxUser=JsonUtil.fromJson(jsonObjec.toString(),WxUser.class);
        wxUser.setSubscribetime(new Date());
        return wxUser;
    }

    /**
     * 根据用户发送的请求，对不同消息进行处理
     * @param request
     * @return
     */
    public static String msgManager(HttpServletRequest request, HttpSession session){
        String msg="";
        try {
            Document xml = new SAXBuilder().build(request.getInputStream());
            String text = XmlUtil.getMsgXmlText(xml, "MsgType");
            if (text.equals("event")) {
                //如果进入的是关注事件
                if (XmlUtil.getMsgXmlText(xml, "Event").equals("subscribe")) {
                    //如果用户是通过扫描带参数的二维码进入的
                    testxml(xml);
                    if(XmlUtil.getMsgXmlText(xml,"EventKey")!=""&&XmlUtil.getMsgXmlText(xml,"EventKey")!=null){
                        msg= subscribeHandler(xml);
                        QrUserGroupService qrUserGroupService=(QrUserGroupService) ApplicationContextUtil.getApplicationContext().getBean("qrUserGroupServiceImpl");
                        String[] split = XmlUtil.getMsgXmlText(xml, "EventKey").split("_");
                        int shareUserId=Integer.parseInt(split[1]);
                        if(shareUserId!=((WxUser)session.getAttribute("d_wxUser")).getId()&&qrUserGroupService.selectByQrIdAndWxId(shareUserId,((WxUser)session.getAttribute("d_wxUser")).getId())==null){
                            QrUserGroup qrUserGroup=new QrUserGroup();
                            qrUserGroup.setQrId(shareUserId);
                            qrUserGroup.setWxId(((WxUser)session.getAttribute("d_wxUser")).getId());
                            qrUserGroupService.insertQrUserGroup(qrUserGroup);
                        }
                        System.out.println("用户通过二维码进入");
                    }else {
                        System.out.println("用户通过关注进入");
                        msg= subscribeHandler(xml);
                    }
                    //如果进入的是取消关注事件
                } else if (xml.getRootElement().getChildText("Event").equals("unsubscribe")) {
                    System.out.println("取消关注事件");
                }
            } else if (text.equals("text")) {
                //进入文本消息

            }else if(text.equals("image")){
                //进入图片消息

            }else if(text.equals("voice")){
                //进入语音消息

            }else if(text.equals("video")){
                //进入视频消息

            }else if(text.equals("shortvideo")){
                //进入小视频消息

            }else if(text.equals("location")){
                //进入地理位置消息

            }else if(text.equals("link")){
                //进入连接消息

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        }
        return msg;
    }
    public static void testxml(Document xml){
        XMLOutputter x=new XMLOutputter();
        ByteArrayOutputStream os=new ByteArrayOutputStream();
        try {
            x.output(xml,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(os.toString());
    }
    /**
     * 关注事件,保存用户信息并对消息被动回复
     * @param xml
     * @return
     */
    private static String subscribeHandler(Document xml) {
        WxUserService wxUserService=(WxUserService) ApplicationContextUtil.getApplicationContext().getBean("wxUserServiceImpl");
        WxUser wxUser = getUserInfo(xml);
        if (wxUserService.selectUserByOpenId(wxUser.getOpenid()) != null) {
            wxUserService.updateUser(wxUser);
        } else {
            wxUserService.insertNewUser(wxUser);
        }
        //被动回复
        MessageService messageService=(MessageService)ApplicationContextUtil.getApplicationContext().getBean("messageServiceImpl");
        List<Message> data=messageService.selectAllMessageByGroupSort();
        WxUser d_wxUser=wxUserService.selectUserByOpenId(wxUser.getOpenid());
        return XmlUtil.createResultXml(XmlUtil.getMsgXmlText(xml, "ToUserName"),XmlUtil.getMsgXmlText(xml, "FromUserName"),"news",data);
    }

    /**
     * 获取带参数的二维码ticket
     */
    public static String getQRcode(int wxId){
        QRCodeService qrCodeService=(QRCodeServiceImpl)ApplicationContextUtil.getApplicationContext().getBean("qRCodeServiceImpl");
        QrCode qrCode=qrCodeService.selectQrCodeByWxId(wxId);
        String expire_seconds="604800";
        String scene_str=String.valueOf(wxId);
        QrCode qrCode1;
        if(qrCode==null){
            qrCode1=createQrCode(expire_seconds,wxId,scene_str);
            qrCodeService.insertNewQrCode(qrCode1);
        }else{
            long expiresTime=Long.parseLong(qrCode.getExpiresIn());
            long currTime=Long.parseLong(String.valueOf(System.currentTimeMillis()));
            long prevTime=Long.parseLong(qrCode.getCreateTime());
            if(currTime-prevTime>expiresTime){
                qrCode1=createQrCode(expire_seconds,wxId,scene_str);
                qrCodeService.updateQrCode(qrCode1);
            }else {
                qrCode1=qrCode;
            }
        }
        return qrCode1.getTicket();
    }

    /**
     * 创建一个新的二维码对象
     * @param expire_seconds
     * @param wxId
     * @param scene_str
     * @return
     */
    public static QrCode createQrCode(String expire_seconds,int wxId,String scene_str){
        String url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+getAccessToken();
        String data="{\"expire_seconds\":"+expire_seconds+" , \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": "+scene_str+"}}}";
        JSONObject jsonObject=HttpClientUtil.doPost(url,data);
        QrCode qrCode2=new QrCode();
        qrCode2.setCreateTime(String.valueOf(System.currentTimeMillis()));
        qrCode2.setWxId(wxId);
        qrCode2.setExpiresIn(expire_seconds);
        qrCode2.setTicket(jsonObject.get("ticket").toString());
        return qrCode2;
    }
    public static String getJsApiTicket(){
        String url="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+WeChatUtil.getAccessToken()+"&type=jsapi";
        JSONObject jsonObject = HttpClientUtil.doGet(url);
        return jsonObject.get("ticket").toString();
    }
    public static void main(String[] args) {
        createMenu();
    }
}
