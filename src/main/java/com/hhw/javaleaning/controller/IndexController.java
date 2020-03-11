package com.hhw.javaleaning.controller;

import com.hhw.javaleaning.dto.PaginationDTO;
import com.hhw.javaleaning.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hhw
 * @date 2020/2/25 下午9:09
 */

@Controller
public class IndexController {


    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "5") Integer size) {
        PaginationDTO paginationDTO = questionService.list(page,size);
        model.addAttribute("pagination", paginationDTO);
        return "index";
    }
}
