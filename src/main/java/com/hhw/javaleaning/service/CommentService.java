package com.hhw.javaleaning.service;

import com.hhw.javaleaning.enums.CommentTypeEnum;
import com.hhw.javaleaning.exception.CustomizeErrorCode;
import com.hhw.javaleaning.exception.CustomizeException;
import com.hhw.javaleaning.mapper.CommentMapper;
import com.hhw.javaleaning.mapper.QuestionExtMapper;
import com.hhw.javaleaning.mapper.QuestionMapper;
import com.hhw.javaleaning.model.Comment;
import com.hhw.javaleaning.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hhw
 * @date 2020/3/16 下午7:48
 */
@Service
public class CommentService {

    @Autowired(required = false)
    private CommentMapper commentMapper;

    @Autowired(required = false)
    private QuestionMapper questionMapper;

    @Autowired(required = false)
    private QuestionExtMapper questionExtMapper;


    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);

        }
        if (comment.getType() == null || CommentTypeEnum.isExist(comment.getType()) == false) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_NOT_FOUND);
        }
        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbcomment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbcomment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }

            commentMapper.insert(comment);
        } else {
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
        }
    }

}
