package com.hhw.javaleaning.exception;

/**
 * @author hhw
 * @date 2020/3/13 下午8:37
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("此问题不存在，请换一个试试");
    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
