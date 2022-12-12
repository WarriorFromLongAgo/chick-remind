package com.xuegao.remind.business.xuegao;

import com.xuegao.util.time.LocalDateTimeUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class XuegaoService {

    public void morning() {
        LocalDateTime now = LocalDateTimeUtil.now();
        int hour = now.getHour();
        int minute = now.getMinute();

        // 当前时间

        // 8点30 - 8点59进行推送
        if (hour == 8 && minute >= 20) {
            System.out.println("早上8点了");
        }
        if (hour == 9 && minute <= 50) {
            System.out.println("早上8点了");
        }
    }

    public void evening() {
        LocalDateTime now = LocalDateTimeUtil.now();
        int hour = now.getHour();
        int minute = now.getMinute();

        // 当前时间

        // 18点00 - 18点59进行推送
        if (hour == 18) {
            System.out.println("早上8点了");
        }
        if (hour == 19) {
            System.out.println("早上8点了");
        }
    }
}
