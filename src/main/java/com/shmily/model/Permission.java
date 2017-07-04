package com.shmily.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by shmily on 2017/6/8.
 */
@Entity
@Table(name = "permission")
public class Permission extends BaseModel<Permission> implements Serializable{

    /**
     * 权限名称
     */
    @NotBlank(message = "权限名称不能为空！！！")
    private String name;

    /**
     * 关于权限的描述
     */
    private String description;

    /**
     * 权限所属模块
     */
    @NotNull(message = "权限所属模块必填")
    private String module;

    /**
     * 资源所对应的包路径
     */
    @NotNull(message = "包路径为必填项")
    private String methodPath;

    /**
     * 是否启用
     */
    @Range(min = 0,max = 1)
    private Integer enable;

    /**
     * 类型，1为程序自动生成，0为人工插入
     */
    @Column(name = "category")
    @Range(min = 0,max = 1)
    private int category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getMethodPath() {
        return methodPath;
    }

    public void setMethodPath(String methodPath) {
        this.methodPath = methodPath;
    }
}
