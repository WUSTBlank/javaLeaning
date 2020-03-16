package com.hhw.javaleaning.exception;

/**
 * @author hhw
 * @date 2020/3/13 下午6:20
 */
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;
    public CustomizeException(String message){
        this.message=message;
    }
    public CustomizeException(ICustomizeErrorCode errorCode){
        this.code=errorCode.getCode();
        this.message=errorCode.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
