package com.xuegao.remind.remind.service;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.xuegao.remind.call.service.RemindCallService;
import com.xuegao.remind.common.Constant;
import com.xuegao.util.time.LocalDateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class XuegaoPushService {
    private static final Logger log = LoggerFactory.getLogger(XuegaoPushService.class);

    @Autowired
    private RemindCallService remindCallService;

    public void pushText(String text) {
        remindCallService.pushText(Constant.PushKey.XUE_GAO_KEY, text);
    }

    public void pushImage(String imageUrl) {
        remindCallService.pushImage(Constant.PushKey.XUE_GAO_KEY, imageUrl);
    }

    public void pushMarkdown(String title, String desp) {
        remindCallService.pushMarkdown(Constant.PushKey.XUE_GAO_KEY, title, desp);
    }

    public void pushRecord(LoadingCache<String, String> cache, String jobName, String executeTime) {
        String cacheKey = jobName + executeTime;
        if (cache.get(cacheKey) != null) {
            log.info("[chick-remind][XuegaoService][pushRecord][cacheKey={}]", cacheKey);
            return;
        }
        String nowTime = LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now());
        this.pushText("推送记录=====" + cacheKey);
        cache.put(cacheKey, nowTime);
        log.info("[chick-remind][XuegaoService][pushRecord][cacheKey推送打卡记录={}]", cacheKey);
    }
}
