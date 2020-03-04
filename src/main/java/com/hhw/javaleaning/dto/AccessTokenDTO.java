package com.hhw.javaleaning.dto;

import lombok.Data;

/**
 * @author hhw
 * @date 2020/2/25 下午9:57
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
