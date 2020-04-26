package com.lx.demo.controller;


import com.lx.demo.utils.EncryDecryUtils;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;

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

    /**
     * 读取一个txt文件，从第二行开始读取
     */
    public static String readTxtFile(String filePath){
        String encoding="UTF-8";
        StringBuffer sBuffer = new StringBuffer();
        try {
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                ArrayList<String> str = new ArrayList<String>();
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
//                    sBuffer.append(lineTxt);
                    str.add(lineTxt);
                }
                read.close();

                for(int i=1;i<str.size();i++){
                    sBuffer.append(str.get(i)+"\n");
                }
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        System.out.println("文件最后为:{}"+ sBuffer.toString());
        return sBuffer.toString();
    }


    /**
     * 对于·本地文件进行加密操作---
     */
    public void makeEncryptionFile(){

        File file = new File ("D:\\文件处理\\影像文件处理\\文件加密\\待加密文件夹");
        File file1 = new File ("D:\\文件处理\\影像文件处理\\文件加密\\加密后文件夹");

        try{
            EncryDecryUtils.makeZip(file.getAbsolutePath(),file1.getAbsolutePath(),"123.zip");
        }catch (IOException e) {
            logger.error("对于文件进行加密的时候异常，异常原因为：【{}】",e);
        }
    }

    /**
     * 对于本地文件进行解密操作
     */
    public void makeDecipheringfile(){

        File file = new File ("D:/文件处理/影像文件处理/文件加密/加密后文件夹/123.zip");
        File file1 = new File ("D:/文件处理/影像文件处理/文件加密/解密后文件夹");

        try{
            EncryDecryUtils.unZip(file.getAbsolutePath(),file1.getAbsolutePath());
        }catch (IOException e) {
            logger.error("对于文件进行解密的时候异常，异常原因为：【{}】",e);
        }
    }

    /**
     * 创建新文件
     */
    public void createNewFile() throws IOException {
        //创建文件夹
        File file1 = new File("D:/文件处理/影像文件处理/文件加密/加密后文件夹1");
        file1.mkdir();
        //创建文件
        File file2 = new File("D:/文件处理/影像文件处理/文件加密/加密后文件夹1/1234.txt");
        file2.createNewFile();
        //对于文件夹下的文件进行循环
        File file3 = new File("D:/文件处理");
        File[] fileList = file3.listFiles();
        for(File file : fileList){
            logger.info(file.getName());
            logger.info(file.getAbsolutePath());
            logger.info(file.getParent());
            logger.info(String.valueOf(file.exists()));
        }


    }

}
