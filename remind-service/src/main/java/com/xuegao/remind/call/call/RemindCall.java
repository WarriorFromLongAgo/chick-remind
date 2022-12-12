package com.xuegao.remind.call.call;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.remind.call.call.impl.RemindCallFallBack;
import com.xuegao.remind.call.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * pushDeer 官方
 */
@FeignClient(name = "pushDeer-official",
        url = "https://api2.pushdeer.com/",
        fallback = RemindCallFallBack.class,
        configuration = FeignConfig.class)
public interface RemindCall {

    @RequestMapping(path = "/message/push", method = RequestMethod.POST)
    JSONObject pushText(@RequestParam(name = "pushkey") String pushKey,
                        @RequestParam(name = "text") String text);

    /**
     * 推送消息，非文本类型
     * pushOther
     *
     * @param pushKey:
     * @param msgType:
     * @param imageUrl: 图片的url
     * @return com.alibaba.fastjson2.JSONObject
     * @author xuegao
     * @date 2022/12/12 20:44
     */
    @RequestMapping(path = "/message/push", method = RequestMethod.POST)
    JSONObject pushImage(@RequestParam(name = "pushkey") String pushKey,
                         @RequestParam(name = "type") String msgType,
                         @RequestParam(name = "text") String imageUrl,
                         @RequestParam(name = "desp") String desp);

    /**
     * 推送消息，非文本类型
     * pushOther
     *
     * @param pushKey:
     * @param msgType:
     * @param text:    标题，图片的url等等
     * @param desp:    <markdown>主题内容等
     * @return com.alibaba.fastjson2.JSONObject
     * @author xuegao
     * @date 2022/12/12 20:44
     */
    @RequestMapping(path = "/message/push", method = RequestMethod.POST)
    JSONObject pushOther(
            @RequestParam(name = "text") String text,
            @RequestParam(name = "desp") String desp,
            @RequestParam(name = "pushkey") String pushKey,
            @RequestParam(name = "type") String msgType);

}