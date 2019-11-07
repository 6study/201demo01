package com.lx.demo.dao;

import com.lx.demo.model.Image;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 查询图片信息表数据
 *
 * @author LiuXue on 2019/9/27
 */
public interface ImgaeDao {

    /**
     * 查询图片信息表数据
     * @return
     */
    @Select("select * from imgae ")
    Image findAllImage();

    /**
     * 查询图片信息表数据
     * @return
     */
    @Select("select * from imgae  where stepId = #{stepId}")
    Image findByStepId(@Param("stepId") String stepId);


}
