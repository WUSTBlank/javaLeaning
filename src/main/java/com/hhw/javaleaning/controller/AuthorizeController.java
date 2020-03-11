package com.hhw.javaleaning.controller;

import com.hhw.javaleaning.dto.AccessTokenDTO;
import com.hhw.javaleaning.dto.GithubUser;
import com.hhw.javaleaning.mapper.UserMapper;
import com.hhw.javaleaning.model.User;
import com.hhw.javaleaning.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author hhw
 * @date 2020/2/25 下午9:45
 */
@Controller
public class AuthorizeController {


    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired(required = false)
    private UserMapper userMapper;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response) {
        System.out.println("callback");
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        System.out.println(accessToken);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        //System.out.println(githubUser.getName());

        if (githubUser != null && githubUser.getName() != null) {
            //登录成功，写cookie和session

            String TOKEN = UUID.randomUUID().toString();
            if (userMapper.findByAccountId(String.valueOf(githubUser.getId())) != null) {
                Integer flag = userMapper.updateUserByAccountId(TOKEN,
                        String.valueOf(githubUser.getId()));

            } else {
                User user = new User();
                user.setToken(TOKEN);
                user.setName(githubUser.getName());
                user.setAccountId(String.valueOf(githubUser.getId()));
                user.setGmtCreate(System.currentTimeMillis());
                user.setGmtModified(user.getGmtCreate());
                user.setAvatarUrl(githubUser.getAvatar_url());
                userMapper.insert(user);
            }
            //登录成功，写cookie和session
            response.addCookie(new Cookie("token", TOKEN));
            return "redirect:/";
        } else {
            //登录失败，重新登录
            System.out.println("登录失败");
            return "redirect:/";
        }

    }
}
