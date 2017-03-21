package com.shmily.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/22.
 * @Entity该注解能让JPA对该类进行持久化处理
 */
@Entity
@Table(name = "role")
public class Role implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    private String roleName;

    private String roleDescribe;

    public Role() {
    }

    public Role(Integer id, String roleName, String roleDescribe) {
        this.id = id;
        this.roleName = roleName;
        this.roleDescribe = roleDescribe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDescribe='" + roleDescribe + '\'' +
                '}';
    }
}
