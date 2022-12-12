package com.xuegao.remind.call.enums;

public enum PushDeerMsgTypeEnum {
    /**
     * code
     */
    TEXT("text", "文字消息"),
    PHOTO("image", "图片消息"),
    MARKDOWN("markdown", "md消息"),
    ;

    private final String code;
    private final String msg;

    PushDeerMsgTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
