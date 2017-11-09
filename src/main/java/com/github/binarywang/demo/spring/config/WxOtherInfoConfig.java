package com.github.binarywang.demo.spring.config;


/**
 * 存储内容，关于微信消息传输过后做的内容
 */
public class WxOtherInfoConfig {

    private String timestamp;

    private String nonce;

    private String signature;


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    // 单例模式

    private static WxOtherInfoConfig ourInstance = new WxOtherInfoConfig();

    public static WxOtherInfoConfig getInstance() {
        return ourInstance;
    }

    private WxOtherInfoConfig() {

    }
}
