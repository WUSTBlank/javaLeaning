package com.hhw.javaleaning.service;

import com.hhw.javaleaning.mapper.UserMapper;
import com.hhw.javaleaning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hhw
 * @date 2020/3/13 上午8:14
 */
@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    public void creatOrupdate(User user) {
        User dbuser = userMapper.findByAccountId(user.getAccountId());
        if (dbuser == null) {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            dbuser.setAvatarUrl(user.getAvatarUrl());
            dbuser.setGmtModified(System.currentTimeMillis());
            dbuser.setToken(user.getToken());
            dbuser.setName(user.getName());
            userMapper.updateUserByAccountId(dbuser);
        }
    }
}
