package com.xuegao.remind.call.call.impl;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.remind.call.call.RemindCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RemindCallFallBack implements RemindCall {
    private static final Logger log = LoggerFactory.getLogger(RemindCallFallBack.class);

    @Override
    public JSONObject pushText(String pushKey, String text) {
        log.info("[chick-remind][RemindCallFallBack][pushText][]");
        return null;
    }

    @Override
    public JSONObject pushImage(String pushKey, String msgType, String imageUrl, String desp) {
        log.info("[chick-remind][RemindCallFallBack][pushImage][]");
        return null;
    }

    @Override
    public JSONObject pushOther(String text, String desp, String pushKey, String msgType) {
        log.info("[chick-remind][RemindCallFallBack][pushOther][]");
        return null;
    }
}
