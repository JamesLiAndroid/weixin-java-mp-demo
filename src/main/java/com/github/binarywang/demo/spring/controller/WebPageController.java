package com.github.binarywang.demo.spring.controller;


import com.github.binarywang.demo.spring.service.WeixinService;
import me.chanjar.weixin.common.bean.WxJsapiSignature;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebPageController {

    @Autowired
    private WeixinService wxService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/hardware", method = RequestMethod.GET,
            produces = "application/json; charset=utf-8")
    protected String hardwareWebPage(Model model) {

        this.logger.debug("\n页面加载！");
//        model.addAttribute("name", userName);
//        model.addAttribute("appId", this.getWxService().getWxMpConfigStorage().getAppId());
//        model.addAttribute("timestamp", this.getWxService().getWxOtherInfoConfig().getTimestamp());
//        model.addAttribute("nonceStr", this.getWxService().getWxOtherInfoConfig().getNonce());
//        model.addAttribute("signature", this.getWxService().getWxOtherInfoConfig().getSignature());

        // TODO: 如何获取请求的绝对路径
        String absoluteUrl = "http://demo.ngrok.lsyandroid.top/hardware";
        // 判断access_token是否过期
        // 判断jsticket是否过期
            try {
                WxJsapiSignature wxJsapiSignature = this.getWxService().createJsapiSignature(absoluteUrl);
//                this.logger.error("duibixinxi!!!!!"+ (this.getWxService().getWxMpConfigStorage().getAppId() == wxJsapiSignature.getAppId()));
                model.addAttribute("wxJsapiSignature", wxJsapiSignature);

                model.addAttribute("js_ticket", this.getWxService().getJsapiTicket());
//                model.addAttribute("access_token", this.getWxService().getAccessToken());
            } catch (WxErrorException e) {
                e.printStackTrace();
                logger.debug("\n生成数据失败！");
            }

        return "hardware";

    }

    @RequestMapping("/hardsuccess")
    protected String hardwareWebPage() {
        return "hardwareSuccess";
    }

    public WeixinService getWxService() {
        return wxService;
    }
}
