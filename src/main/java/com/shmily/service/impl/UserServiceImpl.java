package com.shmily.service.impl;

import com.shmily.dao.UserMapper;
import com.shmily.model.User;
import com.shmily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> allUser() {
        return userMapper.allUser();
    }

    @Override
    public User getByNickName(String name) {
        return userMapper.getByNickName(name);
    }
}
