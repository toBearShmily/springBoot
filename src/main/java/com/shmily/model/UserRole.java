package com.shmily.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by shmily on 2017/6/14.
 */
@Entity
@Table(name = "user_role")
public class UserRole extends BaseModel<UserRole> implements Serializable{

    @Column(name = "user_id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

    @Column(name = "role_id")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;
}
