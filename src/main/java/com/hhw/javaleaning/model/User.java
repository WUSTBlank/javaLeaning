package com.hhw.javaleaning.model;

import lombok.Data;

/**
 * @author hhw
 * @date 2020/2/26 下午12:02
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


}
