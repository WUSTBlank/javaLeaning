package com.hhw.javaleaning.controller;

import com.hhw.javaleaning.dto.PaginationDTO;
import com.hhw.javaleaning.mapper.UserMapper;
import com.hhw.javaleaning.model.User;
import com.hhw.javaleaning.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hhw
 * @date 2020/3/11 下午2:24
 */
@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    @Autowired(required = false)
    private UserMapper userMapper;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "redirect:/";
        }
        System.out.println("userid=" + user.getId());
        if ("questions".contains(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        }
        if ("replies".contains(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }

        PaginationDTO paginationDTO = questionService.listByUserId(user.getId(), page, size);
        model.addAttribute("mypagination", paginationDTO);
        return "profile";
    }
}
