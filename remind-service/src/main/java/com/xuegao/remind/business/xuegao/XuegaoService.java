package com.xuegao.remind.business.xuegao;

import com.github.benmanes.caffeine.cache.LoadingCache;
import com.xuegao.remind.remind.service.XuegaoPushService;
import com.xuegao.util.time.LocalDateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class XuegaoService {
    private static final Logger log = LoggerFactory.getLogger(XuegaoService.class);

    @Autowired
    private XuegaoPushService xuegaoPushService;

    public void morning(LoadingCache<String, String> cache) {
        String jobName = "# 标题:早上不要忘记打卡哦";
        LocalDateTime now = LocalDateTimeUtil.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        String executeTime = LocalDateTimeUtil.localDateTimeToStr(now, LocalDateTimeUtil.PATTERN_YYYY_MM_DD_HH);

        // 8点30 - 8点59进行推送
        if (hour == 8 && minute >= 20) {
            xuegaoPushService.pushMarkdown(jobName, "打卡！打卡！打卡！");
            xuegaoPushService.pushRecord(cache, jobName, executeTime);
        }
        if (hour == 9 && minute <= 50) {
            xuegaoPushService.pushMarkdown(jobName, "打卡！打卡！打卡！");
            xuegaoPushService.pushRecord(cache, jobName, executeTime);
        }
    }

    public void evening(LoadingCache<String, String> cache) {
        String jobName = "标题:下班啦！开溜！！记得打卡！！";
        LocalDateTime now = LocalDateTimeUtil.now();
        String executeTime = LocalDateTimeUtil.localDateTimeToStr(now, LocalDateTimeUtil.PATTERN_YYYY_MM_DD_HH);

        int hour = now.getHour();
        int minute = now.getMinute();

        // 当前时间

        // 18点00 - 18点59进行推送
        if (hour == 18) {
            xuegaoPushService.pushMarkdown(jobName, "打卡！打卡！打卡！");
            xuegaoPushService.pushRecord(cache, jobName, executeTime);
        }
        if (hour == 19) {
            xuegaoPushService.pushMarkdown(jobName, "打卡！打卡！打卡！");
            xuegaoPushService.pushRecord(cache, jobName, executeTime);
        }
    }


}
