package com.github.wxpay.sdk;

import java.io.InputStream;

public class MyWXConfig extends WXPayConfig {

    //千锋账户的APPID
    String getAppID() {
        return "wx632c8f211f8122c6";
    }

    //商户ID
    String getMchID() {
        return "1497984412";
    }

    //商户支付Key
    String getKey() {
        return "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC";
    }

    InputStream getCertStream() {
        return null;
    }

    IWXPayDomain getWXPayDomain() {
        return new WXPayDomain();
    }

    class WXPayDomain implements IWXPayDomain {
        public void report(String domain, long elapsedTimeMillis, Exception ex) {
        }
        public DomainInfo getDomain(WXPayConfig config) {
            return new DomainInfo("api.mch.weixin.qq.com", true);
        }
    }
}
