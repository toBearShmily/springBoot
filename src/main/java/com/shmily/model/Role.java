package com.shmily.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/22.
 * @Entity该注解能让JPA对该类进行持久化处理
 */
@Entity
@Table(name = "role")
public class Role extends BaseModel<Role> implements Serializable{

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "role_describe")
    private String roleDescribe;

    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", roleName='" + roleName + '\'' +
                ", roleDescribe='" + roleDescribe + '\'' +
                '}';
    }
}
