package com.hhw.javaleaning.dto;

import lombok.Data;

/**
 * @author hhw
 * @date 2020/3/16 下午2:52
 */
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private  Integer type;
}
