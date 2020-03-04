package com.hhw.javaleaning.model;

import lombok.Data;

/**
 * @author hhw
 * @date 2020/3/4 下午2:31
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private Long gmtCreate;
    private Long gmtModified;
    private int creator;
    private String tag;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
