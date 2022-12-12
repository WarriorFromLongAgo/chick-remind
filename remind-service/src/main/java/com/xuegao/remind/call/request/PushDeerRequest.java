package com.xuegao.remind.call.request;

import com.xuegao.remind.call.enums.PushDeerMsgTypeEnum;
import com.xuegao.remind.call.enums.PushDeerRemindTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PushDeerRequest {

    /**
     * 发送消息所需要的key
     */
    private String pushKey;

    /**
     * {@link PushDeerMsgTypeEnum}
     * 消息类型
     */
    private String msgType;

    /**
     * 消息内容
     * <p>
     * text 类型，需要URLEncoder.encode(text, "utf-8")
     * image 类型，需要URLEncoder.encode(imageSrc, "utf-8")
     * markdown 类型，需要URLEncoder.encode(markdown, "utf-8")
     */
    private String content;

    /**
     * {@link PushDeerRemindTypeEnum}
     * 提醒类型
     */
    private String remindType;
}
