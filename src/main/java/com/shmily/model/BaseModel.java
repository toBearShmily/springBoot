package com.shmily.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by shmily on 2017/6/8.
 */
@MappedSuperclass
public class BaseModel<T> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time", updatable = false)
    private String createTime;

    /**
     * 修改时间
     */
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "update_time", updatable = false)
    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
