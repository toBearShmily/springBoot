package com.shmily.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 角色权限关联表
 * Created by shmily on 2017/6/13.
 */
@Entity
@Table(name = "role_permission")
public class RolePermission extends BaseModel<RolePermission> implements Serializable{
    /**
     * 关联角色表
     */
    @Column(name = "roleId")
    @NotNull(message = "角色id不能为空")
    private Integer roleId;

    /**
     * 关联权限表（即对应的资源）
     */
    @Column(name = "PermissId")
    @NotNull(message = "权限id不能为空")
    private Integer PermissId;

}
