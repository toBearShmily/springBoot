package com.shmily.dao;

import com.shmily.model.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface RoleJPA extends CrudRepository<Role,Integer> {
}
