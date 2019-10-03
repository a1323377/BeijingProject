package com.yh.utils;

import com.yh.domain.Message;
import org.jdom2.CDATA;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.util.List;


public class XmlUtil {
    /***
     * 根据节点名字解析微信平台发送的消息xml数据包
     * 返回节点中的文本
     */
    public static String getMsgXmlText(Document document,String elementName){
        return document.getRootElement().getChildText(elementName);
    }
    public static String createResultXml(String fromUserName, String toUserName,String msgType ,List<Message>data){
        Element element=new Element("xml");
        element.addContent(new Element("ToUserName").addContent(new CDATA(toUserName)));
        element.addContent(new Element("FromUserName").addContent(new CDATA(fromUserName)));
        element.addContent(new Element("CreateTime").addContent(new CDATA(String.valueOf(System.currentTimeMillis()))));
        element.addContent(new Element("MsgType").addContent(new CDATA(msgType)));
        element.addContent(new Element("ArticleCount").addContent(new CDATA(String.valueOf(data.size()))));
        Element articles=new Element("Articles");
        for (Message datum : data) {
            Element item=new Element("item");
            item.addContent(new Element("Title").addContent(new CDATA(datum.getTitle())));
            item.addContent(new Element("Description").addContent(new CDATA(datum.getDescription())));
            item.addContent(new Element("PicUrl").addContent(new CDATA(datum.getPicurl())));
            item.addContent(new Element("Url").addContent(new CDATA("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WeChatUtil.APPID+"&redirect_uri="+EncryptUtil.encodingUrl(datum.getUrl())+"?&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect")));
            articles.addContent(item);
        }
        element.addContent(articles);
        Format format=Format.getCompactFormat();
        format.setEncoding("utf-8");
        XMLOutputter outputter=new XMLOutputter();
        return outputter.outputString(element);
    }
}
