package com.hhw.javaleaning.exception;

/**
 * @author hhw
 * @date 2020/3/13 下午6:20
 */
public class CustomizeException extends RuntimeException {
    private String message;
    public CustomizeException(String message){
        this.message=message;
    }
    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message=errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
