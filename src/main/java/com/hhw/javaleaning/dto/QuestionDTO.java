package com.hhw.javaleaning.dto;

import com.hhw.javaleaning.model.User;
import lombok.Data;

/**
 * @author hhw
 * @date 2020/3/10 下午4:41
 */
@Data
public class QuestionDTO {
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
    private User user;
}
