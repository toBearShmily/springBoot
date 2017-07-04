package com.shmily.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user")
public class User extends BaseModel<User> implements Serializable{

    /**
     *昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 密码
     */
    @Column(name = "password")
    @NotBlank
    private String password;

    @Column(name = "email")
    @Email
    private String email;

    /**
     * 性别
     */
    @Column(name = "sex")
    private Integer sex;

    /**
     * 头像
     */
    @Column(name = "imgUrl")
    private String img;

    /**
     * 是否代理
     */
    @Column(name = "isProxy")
    private Integer isProxy;

    /**
     * 角色id
     * 每次添加的时候会给予当前用户一个默认权限
     */
    @Column(name = "role_id", nullable = false)
    private Integer roleId = 22;

    /**
     * 最后一次登录时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_login_time")
    @Temporal(value = TemporalType.TIME)
    private Date lastLoginTime;



    public User() {
    }

    public User(String nickName, String password, String email, Integer sex, String img, Integer isProxy, Integer roleId, Date lastLoginTime) {
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.img = img;
        this.isProxy = isProxy;
        this.roleId = roleId;
        this.lastLoginTime = lastLoginTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getIsProxy() {
        return isProxy;
    }

    public void setIsProxy(Integer isProxy) {
        this.isProxy = isProxy;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}