package com.xuegao.remind.call.service;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.remind.call.call.RemindCall;
import com.xuegao.remind.call.enums.PushDeerMsgTypeEnum;
import org.apache.catalina.manager.Constants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class RemindCallService {
    private static final Logger log = LoggerFactory.getLogger(RemindCallService.class);

    @Autowired
    private RemindCall remindCall;

    /**
     * 推送文本消息
     * pushText
     *
     * @param text:
     * @author xuegao
     * @date 2022/12/12 20:57
     */
    public void pushText(String pushKey,
                         String text) {
        JSONObject jsonObject = remindCall.pushText(pushKey, text);
        if (log.isDebugEnabled()) {
            log.info("[chick-remind][RemindCallService][pushText][jsonObject={}]", jsonObject);
        }
    }

    /**
     * 推送图片
     * pushImage
     *
     * @param imageUrl:
     * @author xuegao
     * @date 2022/12/12 20:57
     */
    public void pushImage(String pushKey,
                          String imageUrl) {
        String imageUrlUtf8 = null;
        try {
            imageUrlUtf8 = URLEncoder.encode(imageUrl, Constants.CHARSET);
        } catch (UnsupportedEncodingException e) {
            log.info("[chick-remind][RemindCallService][pushImage][e={}]", e.getMessage(), e);
        }
        if (StringUtils.isBlank(imageUrlUtf8)) {
            log.info("[chick-remind][RemindCallService][pushImage][imageUrlUtf8={}]", imageUrlUtf8);
            return;
        }
        JSONObject jsonObject = remindCall.pushImage(pushKey, PushDeerMsgTypeEnum.PHOTO.getCode(), imageUrl, "图片备注");
        if (log.isDebugEnabled()) {
            log.info("[chick-remind][RemindCallService][pushImage][jsonObject={}]", jsonObject);
        }
    }

    /**
     * 推送消息，非文本类型
     * pushOther
     *
     * @param title:
     * @param desp:
     * @author xuegao
     * @date 2022/12/12 20:57
     */
    public void pushOther(String pushKey,
                          String title,
                          String desp) {
        String titleUtf8 = null;
        String despUtf8 = null;
        try {
            titleUtf8 = URLEncoder.encode(title, Constants.CHARSET);
            despUtf8 = URLEncoder.encode(desp, Constants.CHARSET);
        } catch (UnsupportedEncodingException e) {
            log.info("[chick-remind][RemindCallService][pushOther][e={}]", e.getMessage(), e);
        }
        if (StringUtils.isBlank(titleUtf8) || StringUtils.isBlank(despUtf8)) {
            log.info("[chick-remind][RemindCallService][pushOther][titleUtf8={}][despUtf8={}]", titleUtf8, despUtf8);
            return;
        }
        JSONObject jsonObject = remindCall.pushOther(pushKey, PushDeerMsgTypeEnum.MARKDOWN.getCode(), titleUtf8, despUtf8);
        if (log.isDebugEnabled()) {
            log.info("[chick-remind][RemindCallService][pushOther][jsonObject={}]", jsonObject);
        }
    }
}
