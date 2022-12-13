package com.xuegao.remind.remind.controller;

import com.xuegao.remind.remind.service.XuegaoPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XuegaoPushController {

    @Autowired
    private XuegaoPushService xuegaoPushService;

    @RequestMapping(path = "/xuegao/pushText", method = RequestMethod.POST)
    public void pushText(String text) {
        xuegaoPushService.pushText(text);
    }

    @RequestMapping(path = "/xuegao/pushImage", method = RequestMethod.POST)
    public void pushImage(String imageUrl) {
        xuegaoPushService.pushImage(imageUrl);
    }

    @RequestMapping(path = "/xuegao/pushOther", method = RequestMethod.POST)
    public void pushOther(String title, String desp) {
        xuegaoPushService.pushMarkdown("# 第一条markdown消息", "**optional**+description+in+markdown");
    }

}
