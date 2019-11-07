package com.lx.demo.dao;

import com.lx.demo.model.WaitDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 查询代办信息表数据
 *
 * @author LiuXue on 2019/9/27
 */
@Mapper
public interface WaitDoDao {

    /**
     * 查询待办信息表数据
     * @return
     */
    @Select("select * from wait_do ")
    WaitDo findAllWaitDo();


    }
