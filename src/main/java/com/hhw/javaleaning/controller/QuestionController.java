package com.hhw.javaleaning.controller;

import com.hhw.javaleaning.dto.QuestionDTO;
import com.hhw.javaleaning.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author hhw
 * @date 2020/3/11 下午5:38
 */
@Controller
public class QuestionController {

    @Autowired(required = false)
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id") Integer id,
                           Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
