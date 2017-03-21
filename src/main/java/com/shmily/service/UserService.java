package com.shmily.service;

import com.shmily.model.User;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface UserService {

    public List<User> allUser();

    public User getByNickName(String name);
}
