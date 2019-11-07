package com.lx.demo.dao;

import com.lx.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户信息操作
 */
@Mapper
public interface UserDao {

    /**
     * 通过username 以及password 查询 user表
     * @param username
     * @return
     */
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    List<User> findByUsernameAndPassword(@Param("username") String username,@Param("password")String password);

    /**
     * 对于用户详情表进行查询
     * @param userNo
     * @return
     */
    @Select("select * from user_detail where userNo=#{userNO}")
    User findByUserNo(@Param("userNo")String userNo);


    /**
     * 对于user表数据进行插入
     * @param user
     * @return
     */
    int insert(User user);



}
