package com.hhw.javaleaning.controller;

import com.hhw.javaleaning.dto.QuestionDTO;
import com.hhw.javaleaning.mapper.UserMapper;
import com.hhw.javaleaning.model.User;
import com.hhw.javaleaning.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hhw
 * @date 2020/2/25 下午9:09
 */

@Controller
public class IndexController {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model) {


        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return "index";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        List<QuestionDTO>  questionList=questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }
}
