package com.xuegao.remind.call.enums;

public enum PushDeerRemindTypeEnum {
    /**
     * code
     */
    TYPE_10(10, "平常通知"),
    TYPE_20(20, "推送记录以及提醒"),

    ;

    private final int code;
    private final String msg;

    PushDeerRemindTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
