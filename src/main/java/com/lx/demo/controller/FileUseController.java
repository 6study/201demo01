package com.lx.demo.controller;


import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * 对于文件类进行使用
 *
 * @author LiuXue on 2019/11/7
 */
@RestController
public class FileUseController {

    private static Logger logger= LoggerFactory.getLogger(FileUseController.class);

    /**
     * 实现简单的写文件操作--对于后续批量化文件进行处理
     * 实现自定义文件的生成
     */
    public void  writeIntoFile01(){

        StringBuffer  stringB = new StringBuffer();
        stringB.append("这是文件的第一行  A \n");
        stringB.append("这是文件的第二行  B \n");
        stringB.append(" \n");
        stringB.append(" C \n");
        stringB.append(" \n");
        stringB.append(" \n");
        File file = new File("D:\\文件处理\\影像文件处理\\简单文件\\2.txt"); //写入文件的位置
        try {
            FileUtils.writeStringToFile(file,stringB.toString(),"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("对于string 进行文件写入的时候异常，异常原因为 ：【{}】",e.getMessage());
        }
        //对于文件进行重复写操作   -- 默认false 不保留之前一次文件内容  true 为保留原有内容新增
        try {
            FileUtils.writeStringToFile(file,"hahaha","utf-8",true);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("对于string 进行文件写入的时候异常，异常原因为 ：【{}】",e.getMessage());
        }

    }

    /**
     * 对于文件中的字符进行查看以及修改
     *  ！注意：（这个时候read了文件那么写进去的文件是最新的）
     */
    public void  writeIntoFile02(){

        File file = new File("D:\\文件处理\\影像文件处理\\简单文件\\2.txt"); //写入文件的位置
        try {
            String abc=FileUtils.readFileToString(file,"utf-8");
            logger.info("查询出来文件中 数据为："+abc);
            String def=abc.replace("A","cs").replace("B","vx");
            FileUtils.writeStringToFile(file,def,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("对于string 进行文件写入的时候异常，异常原因为 ：【{}】",e.getMessage());
        }
    }

}
