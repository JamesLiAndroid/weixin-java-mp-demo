package com.github.binarywang.demo.spring.controller;


import com.github.binarywang.demo.spring.service.WeixinService;
import me.chanjar.weixin.common.exception.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WebPageController {

    @Autowired
    private WeixinService wxService;

    @RequestMapping("/hardware/{userName}")
    protected String pageGet(@PathVariable("userName") String userName, Model model) {

        model.addAttribute("name", userName);
        model.addAttribute("appId", this.getWxService().getWxMpConfigStorage().getAppId());
        model.addAttribute("timestamp", this.getWxService().getWxOtherInfoConfig().getTimestamp());
        model.addAttribute("nonceStr", this.getWxService().getWxOtherInfoConfig().getNonce());
        model.addAttribute("signature", this.getWxService().getWxOtherInfoConfig().getSignature());

        return "hardware";

    }

    public WeixinService getWxService() {
        return wxService;
    }
}
