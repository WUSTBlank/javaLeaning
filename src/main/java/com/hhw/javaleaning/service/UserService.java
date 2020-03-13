package com.hhw.javaleaning.service;

import com.hhw.javaleaning.mapper.UserMapper;
import com.hhw.javaleaning.model.User;
import com.hhw.javaleaning.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hhw
 * @date 2020/3/13 上午8:14
 */
@Service
public class UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    public void creatOrupdate(User user) {

        UserExample example = new UserExample();
        example.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> dbusrs = userMapper.selectByExample(example);
        if (dbusrs.size() == 0) {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(dbusrs.get(0).getId());
            User updateUser = new User();
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setToken(user.getToken());
            updateUser.setName(user.getName());
            userMapper.updateByExampleSelective(updateUser, userExample);
        }
    }
}
