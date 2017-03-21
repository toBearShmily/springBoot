package com.shmily.dao;

import com.shmily.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
@Resource
public interface UserMapper {

    @Select("select * from user")
    public List<User> allUser();

    @Select("select * from user where nick_name = #{name}")
    public User getByNickName(@Param("name") String name);
}
