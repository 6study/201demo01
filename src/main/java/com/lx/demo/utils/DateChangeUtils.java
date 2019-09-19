package com.lx.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * 对于日期类型常用转化通用工具类
 */
public class DateChangeUtils {

    private  static Logger logger=LoggerFactory.getLogger(DateChangeUtils.class);

    //常用日期类型转换类型
    private  static  String dateType01="yyyyMMdd";    //暂时只使用第一个，使用其他依此类推
    private  static  String dateType02="HHmmss";
    private  static  String dateType03="yyyyMMddHHmmss";
    private  static  String dateType04="yyyy-MM-dd";
    private  static  String dateType05="HH:mm:ss";
    private  static  String dateType06="yyyy-MM-dd HH:mm:ss";

    public String getStringDateType01(Date date01){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(dateType01);
        String dateType01=simpleDateFormat.format(date01);
        return dateType01;
    }

    public Date getDateDateType01(String date01){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(dateType01);
        Date date=null;
        try {
            date=simpleDateFormat.parse(date01);
        } catch (ParseException e) {
            logger.error("对于日期类型进行转换的时候异常");
            e.printStackTrace();
        }
        return new Date()  ;
    }




    //************

    /**
     * 获取输入日期后count天日期
     * @param date
     * @param count
     * @return
     */
    public  Date getDateAfterCount(Date date,int count){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,count);
        return calendar.getTime();
    }

    /**
     * 获取输入日期前count天日期
     * @param date
     * @param count
     * @return
     */
    public  Date getDateBeforeCount(Date date,int count){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH,-count);
        return calendar.getTime();
    }

    /**
     * 对于输入的日期和当前日期进行比较  大 为true 小为 false
     * @param date
     * @return
     */
    public Boolean  dateCompare(Date date){
        Date date1=new Date();
        if(date.getTime()>=date1.getTime()){
            return  true;
        }else{
            return false;
        }
    }





}
