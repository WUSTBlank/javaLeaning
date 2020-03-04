package com.hhw.javaleaning.dto;

import lombok.Data;

/**
 * @author hhw
 * @date 2020/2/25 下午10:51
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
