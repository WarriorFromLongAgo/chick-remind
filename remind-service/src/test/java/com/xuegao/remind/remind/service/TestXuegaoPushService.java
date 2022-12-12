package com.xuegao.remind.remind.service;

import com.xuegao.remind.RemindServiceApplication;
import com.xuegao.remind.common.Constant;
import com.xuegao.util.time.LocalDateTimeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = RemindServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestXuegaoPushService {

    @Autowired
    private XuegaoPushService xuegaoPushService;

    @Test
    public void pushText() {
        String nowStr = LocalDateTimeUtil.localDateTimeToStr(LocalDateTimeUtil.now());
        xuegaoPushService.pushText(nowStr + Constant.Symbol.CRLF + nowStr);
    }

    @Test
    public void pushImage() {
        String imageUrl = "https://pic1.zhimg.com/v2-c29322edcd03ead5207049b44abad0d8_r.jpg";
        xuegaoPushService.pushImage(imageUrl);
    }

    @Test
    public void pushOther() {
        xuegaoPushService.pushOther("# 第一条markdown消息", "# 一级标题 ## 二级标题 **optional**+description+in+markdown+阿斯顿撒打算");
    }
}
