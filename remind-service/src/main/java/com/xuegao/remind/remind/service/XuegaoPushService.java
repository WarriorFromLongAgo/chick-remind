package com.xuegao.remind.remind.service;

import com.xuegao.remind.call.service.RemindCallService;
import com.xuegao.remind.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XuegaoPushService {

    @Autowired
    private RemindCallService remindCallService;

    public void pushText(String text) {
        remindCallService.pushText(Constant.PushKey.XUE_GAO_KEY, text);
    }

    public void pushImage(String imageUrl) {
        remindCallService.pushImage(Constant.PushKey.XUE_GAO_KEY, imageUrl);
    }

    public void pushOther(String title, String desp) {
        remindCallService.pushOther(Constant.PushKey.XUE_GAO_KEY, title, desp);
    }

}
