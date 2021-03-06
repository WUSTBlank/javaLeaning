package com.hhw.javaleaning.exception;

/**
 * @author hhw
 * @date 2020/3/13 下午8:37
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"此问题不存在，请换一个试试"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行回复"),
    NO_LOGIN(2003,"当前操作需要登录,请登录后重试"),
    SYS_ERROR(2004,"服务器冒烟啦，请稍后再试！"),
    TYPE_PARAM_NOT_FOUND(2005,"评论类型错误或为null"),
    COMMENT_NOT_FOUND(2005,"回复的评论不存在了");
    private String message;
    private Integer code;

    CustomizeErrorCode(Integer code,String message) {
        this.code=code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }



}
