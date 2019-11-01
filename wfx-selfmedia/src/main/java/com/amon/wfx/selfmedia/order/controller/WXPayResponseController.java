package com.amon.wfx.selfmedia.order.controller;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import io.goeasy.GoEasy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class WXPayResponseController {

    @RequestMapping("pay/notify_url")
    public void notifiUrl(HttpServletRequest request, HttpServletResponse response){
        try {

            ServletInputStream inputStream = request.getInputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = inputStream.read(buffer))!= -1){
                stringBuilder.append(new String(buffer,0,len));
            }
            System.out.println(stringBuilder.toString());


            //响应数据给平台
            try {
                Map<String,String> xmlToMap = WXPayUtil.xmlToMap(stringBuilder.toString());
                String trade_no = xmlToMap.get("out_trade_no");
                String payurl = xmlToMap.get("code_url");
                request.getSession().setAttribute("payUrl",payurl);

            } catch (Exception e) {
                e.printStackTrace();
            }

            response.getWriter().println("<xml>\n" +
                    "   <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                    "   <return_msg><![CDATA[OK]]></return_msg>\n" +
                    "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                    "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
                    "   <nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str>\n" +
                    "   <openid><![CDATA[oUpF8uMuAJO_M2pxb1Q9zNjWeS6o]]></openid>\n" +
                    "   <sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign>\n" +
                    "   <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                    "   <prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id>\n" +
                    "   <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                    "</xml>");

            GoEasy goEasy = new GoEasy("http://rest-hangzhou.goeasy.io", "BC-82e2e2069d70497abd91c0a7c732cbe5");
            goEasy.publish("qf123456","pay-success");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
