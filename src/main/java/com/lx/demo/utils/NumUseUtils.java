package com.lx.demo.utils;

/**
 * 对于num使用进行操作util类
 *
 * @author LiuXue on 2019/11/7
 */
public class NumUseUtils
{

    /**
     * 实现自增序列号 0000-9999
     * @param num
     * @return
     */
    public static String getNumber(int num)
    {
        num++;
        String result = "";
        switch ((num+"").length()) {
            case 1:
                result = "000" + num;
                break;
            case 2:
                result = "0" + num;
                break;
            case 3:
                result = "0" + num;
                break;
            case 4:
                result = "" + num;
                break;
// 此处代表编号已经超过了9999，从0重新开始
            default:
                result = "0000";
                break;
        }
        return result;
    }
}
