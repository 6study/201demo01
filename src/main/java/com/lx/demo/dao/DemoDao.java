package com.lx.demo.dao;

import com.lx.demo.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 对于常规查询使用的demo
 *
 * @author LiuXue on 2019/10/23
 */
public interface DemoDao {


    /**
     * 常用查询使用 动态sql
     * @param userNo
     * @return
     */
    @Select("<script> " +
            "select * from user_detail " +
            "where 1=1  " +
            "< if  test=' userNo != null ' > "+
            "userNo=#{userNo}" +
            "</if>"+
            "</script>")
    User findByUserNoAndUserNmae(@Param("userNo")String userNo,@Param("userName")String userName);
}
