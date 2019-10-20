package com.yh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.commons.ResponseJson;
import com.yh.commons.WeChatCommon;
import com.yh.domain.Scroll;
import com.yh.domain.Shoppingcar;
import com.yh.domain.SkuStore;
import com.yh.domain.WxUser;
import com.yh.service.*;
import com.yh.utils.EncryptUtil;
import com.yh.utils.WeChatUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class WeChatController {
    @Resource(name = "wxUserServiceImpl")
    WxUserService wxUserService;
    @Resource(name = "scrollServiceImpl")
    ScrollService scrollService;
    @Resource(name = "skuStoreServiceImpl")
    SkuStoreService skuStoreService;
    @Resource(name = "standardValueServiceImpl")
    StandardValueService standardValueService;
    @Resource(name = "shoppingCarServiceImpl")
    ShoppingCarService shoppingCarService;
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

    /**
     * 初始化首页
     * @return
     */
    @RequestMapping(value = "init",method = RequestMethod.POST)
    public ResponseJson initIndex(int pageIndex){
        Map<String,Object> dataMap=new HashMap<>();
        List<Scroll> indexScroll=scrollService.selectScrollOrderByCreateTime();
        PageHelper.startPage(pageIndex,3);
        List<Map<String,String>> skuInfo=skuStoreService.selectSkuOrderByCreateTime();
        PageInfo<Map<String,String>> pageInfo=new PageInfo<>(skuInfo);
        System.out.println(pageInfo.toString());
        List<Map<String,String>> skuRush=skuStoreService.selectSkuRush();
        dataMap.put("scrollImg",indexScroll);
        dataMap.put("skuInfo",skuInfo);
        dataMap.put("skuRush",skuRush);
        dataMap.put("skuPage",pageInfo);
        return new ResponseJson(0,"success",dataMap);
    }
    @RequestMapping(value = "getgoods",method = RequestMethod.POST)
    public ResponseJson getGoods(int pageIndex){
        Map<String,Object> dataMap=new HashMap<>();
        PageHelper.startPage(pageIndex,3);
        List<Map<String,String>> skuInfo=skuStoreService.selectSkuOrderByCreateTime();
        dataMap.put("skuInfo",skuInfo);
        return  new ResponseJson(0,"success",dataMap);
    }

    @RequestMapping(value = "getdetails",method = RequestMethod.GET)
    public ResponseJson getDetails(int skuId,int productId){
        Map<String,String> skuDetail=skuStoreService.selectSkuDetail(skuId);
        List<Map<String,String>> skuScrollImg=skuStoreService.selectSkuScrollImg(skuId);
        List<Map<String,String>> skus=skuStoreService.selectSkuByProductId(productId);
        List<Map<String,String>> standardValue=standardValueService.selectStandardValueByProductId(productId);
        SkuStore sku=skuStoreService.selectSku(skuId);
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("skus",skus);
        dataMap.put("skuDetail",skuDetail);
        dataMap.put("skuScrollImg",skuScrollImg);
        dataMap.put("sku",sku);
        dataMap.put("standardValue",standardValue);
        return  new ResponseJson(0,"success",dataMap);
    }
    @RequestMapping(value = "verifylogin",method = RequestMethod.GET)
    public String verifyLogin(HttpSession session){
        if(session.getAttribute("d_wxUser")!=null){
            return "true";
        }
        return "false";
    }

    /**
     * 加入购物车
     * @param shoppingcar
     * @param session
     * @return
     */
    @RequestMapping(value = "addshoppingcar",method = RequestMethod.POST)
    public ResponseJson addShoppingCar(Shoppingcar shoppingcar, HttpSession session){
        shoppingcar.setCarUserid(((WxUser)session.getAttribute("d_wxUser")).getId());
        int result=shoppingCarService.insertShoppingCar(shoppingcar);
        if(result>0){
            return new ResponseJson(0,"success",null);
        }else {
            return new ResponseJson(1,"faild",null);
        }
    }
    @RequestMapping(value = "getmycar" ,method = RequestMethod.GET)
    public ResponseJson getMyCar(HttpSession session){
        List<Map<String,String>> mycar=shoppingCarService.getMyCar(((WxUser)session.getAttribute("d_wxUser")).getId());
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("mycar",mycar);
        return  new ResponseJson(0,"success",dataMap);
    }
}
