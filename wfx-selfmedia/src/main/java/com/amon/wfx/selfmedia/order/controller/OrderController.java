package com.amon.wfx.selfmedia.order.controller;

import com.amon.wfx.selfmedia.order.pojos.Order;
import com.amon.wfx.selfmedia.order.service.impl.OrderService;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.wxpay.sdk.MyWXConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("order/add")
    @ResponseBody
    public String addOrder(@RequestBody Order order,  HttpServletRequest request){
        try {
            String orderId = orderService.addOrder(order);
            WXPay wxPay = new WXPay(new MyWXConfig());
            Map<String,String> data = new HashMap<>();
            data.put("body","amon");
            data.put("out_trade_no", orderId);
            data.put("device_info", "PC");
            data.put("fee_type", "CNY");
            data.put("total_fee", "1");
            data.put("spbill_create_ip", "123.12.12.123");
            //支付成功之后的回调接口
            data.put("notify_url", "http://76nzrr.natappfree.cc/pay/notify_url");
            // 此处指定为扫码支付
            data.put("trade_type", "NATIVE");
            data.put("product_id", "12");

            Map<String, String> resp = wxPay.unifiedOrder(data);
            String codeUrl=resp.get("code_url");
            request.getSession().setAttribute("pay_url",codeUrl);
            request.getSession().setAttribute("order",order);


            return "true#success";
        } catch (Exception e) {
            e.printStackTrace();
            return "false#fail";
        }
    }


    @RequestMapping("order/qrcode")
    public void createQrcode(HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();
        String payUrl = session.getAttribute("pay_url").toString();
        //通过支付链接生成二维码
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        hints.put(EncodeHintType.MARGIN, 2);
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(payUrl, BarcodeFormat.QR_CODE, 200, 200, hints);
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", response.getOutputStream());
            System.out.println("创建二维码完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
