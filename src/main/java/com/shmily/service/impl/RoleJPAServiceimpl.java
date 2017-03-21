package com.shmily.service.impl;

import com.shmily.dao.RoleJPA;
import com.shmily.model.Role;
import com.shmily.service.RoleJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/2/22.
 */
@Service("roleJPAService")
public class RoleJPAServiceimpl implements RoleJPAService {

    @Autowired
    private RoleJPA roleJPA;

    @Transactional
    @Override
    public void save(Role role) {
        roleJPA.save(role);
    }

    @Override
    public void delete(Integer id) {
        roleJPA.delete(id);
    }
}
