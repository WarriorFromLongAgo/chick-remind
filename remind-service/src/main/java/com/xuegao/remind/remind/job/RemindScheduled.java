package com.xuegao.remind.remind.job;

import com.github.benmanes.caffeine.cache.*;
import com.xuegao.remind.business.xuegao.XuegaoService;
import com.xuegao.util.time.LocalDateTimeUtil;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RemindScheduled {
    private static final Logger log = LoggerFactory.getLogger(RemindScheduled.class);

    @Autowired
    private XuegaoService xuegaoService;

    private static LoadingCache<String, String> CACHE;

    static {
        CACHE = Caffeine.newBuilder()
                //cache的初始容量
                .initialCapacity(1)
                //cache最大缓存数,设置缓存最大条目数，超过条目则触发回收。
                .maximumSize(2)
                // 缓存淘汰监听器，配置监听器后，每个条目淘汰时都会调用该监听器
                .removalListener(new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(@Nullable String key, @Nullable String value, @NonNull RemovalCause removalCause) {
                        log.info("[chick-remind][RemindScheduled][onRemoval][key={}][value={}]", key, value);
                    }
                })
                .build(new CacheLoader<String, String>() {
                    @Override
                    public @Nullable String load(@NonNull String s) throws Exception {
                        return null;
                    }
                });
    }


    /**
     * 每一秒钟执行一次，取出一个任务，进行判断时间是否到了
     * coreScheduled
     * <p>
     * 2022-12-12 22:26:07
     * 2022-12-12 22:26:08
     * 2022-12-12 22:26:09
     * 2022-12-12 22:26:10
     * 2022-12-12 22:26:11
     *
     * @author xuegao
     * @date 2022/12/12 22:22
     */
    // @Scheduled(cron = "0/1 * * * * ? ")
    public void coreScheduledBy1s() {
        String nowStr = LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now());
        log.info("[chick-remind][RemindScheduled][coreScheduledBy1s][nowStr={}]", nowStr);
    }


    /**
     * 每一分钟钟执行一次，取出一个任务，进行判断时间是否到了
     * coreScheduled
     * <p>
     * 2022-12-12 22:26:00
     * 2022-12-12 22:27:00
     * 2022-12-12 22:28:00
     * 2022-12-12 22:29:00
     * 2022-12-12 22:30:00
     *
     * @author xuegao
     * @date 2022/12/12 22:22
     */
    // @Scheduled(cron = "0 0/1 * * * ? ")
    // public void coreScheduledBy1Min() {
    //     String nowStr = LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now());
    //     log.info("[chick-remind][RemindScheduled][coreScheduledBy1Min][nowStr={}]", nowStr);
    // }

    /**
     * 每5分钟钟执行一次，取出一个任务，进行判断时间是否到了
     * coreScheduled
     * <p>
     * 2022-12-12 22:30:00
     * 2022-12-12 22:35:00
     * 2022-12-12 22:40:00
     * 2022-12-12 22:45:00
     * 2022-12-12 22:50:00
     *
     * @author xuegao
     * @date 2022/12/12 22:22
     */
    // @Scheduled(cron = "0 0/5 * * * ? ")
    // public void coreScheduledBy5Min() {
    //     String nowStr = LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now());
    //     log.info("[chick-remind][RemindScheduled][coreScheduledBy5Min][nowStr={}]", nowStr);
    // }


    /**
     * 早上的8点和9点，每10分钟钟执行一次，取出一个任务，进行判断时间是否到了
     * coreScheduled
     * <p>
     * 2022-12-13 08:00:00
     * 2022-12-13 08:10:00
     * 2022-12-13 08:20:00
     * 2022-12-13 08:30:00
     * 2022-12-13 08:40:00
     *
     * @author xuegao
     * @date 2022/12/12 22:22
     */
    @Scheduled(cron = "0 0/15 8,9 * * ? ")
    public void coreScheduledByMorning() {
        String nowStr = LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now());
        log.info("[chick-remind][RemindScheduled][coreScheduledByMorning][nowStr={}]", nowStr);

        xuegaoService.morning(CACHE);
    }

    /**
     * 下午的18点和19点，每10分钟钟执行一次，取出一个任务，进行判断时间是否到了
     * coreScheduled
     * <p>
     * 2022-12-14 18:00:00
     * 2022-12-14 18:10:00
     * 2022-12-14 18:20:00
     * 2022-12-14 18:30:00
     * 2022-12-14 18:40:00
     *
     * @author xuegao
     * @date 2022/12/12 22:22
     */
    @Scheduled(cron = "0 0/10 18,19 * * ? ")
    public void coreScheduledByEvening() {
        String nowStr = LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now());
        log.info("[chick-remind][RemindScheduled][coreScheduledByEvening][nowStr={}]", nowStr);

        xuegaoService.evening(CACHE);
    }
}
