package com.shmily.service;

import com.shmily.model.Role;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface RoleJPAService {

    public void save(Role role);

    public void delete(Integer id);

}
