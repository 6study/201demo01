package com.lx.demo.controller.exercise;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * FileChange
 *
 * @author LiuXue on 2020/3/15
 */
public class FileChange {

    public static void main(String[] args) {

        try {
            File fileA=new File("D:/A.txt");
            File fileB=new File("D:/B.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileA));
            FileWriter writerFlie = new FileWriter(fileB, true);
            BufferedWriter bufferWriter = new BufferedWriter(writerFlie);

            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
                String StringB= selectSort((String[])(lineTxt.split("\\|")));//排序
                bufferWriter.write(StringB);
                bufferWriter.newLine();
                writerFlie.flush();
            }
            bufferWriter.close();
            writerFlie.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 重新排序后 内容
     * @param lineString
     * @return
     */
    public static String selectSort(String[] lineString) {
        //进行排序
        for (int i = 0; i < lineString.length - 1; i++) {
            for (int j = i + 1; j < lineString.length; j++) {
                int a = Integer.parseInt(lineString[i]);
                int b = Integer.parseInt(lineString[j]);
                if (a > b) {
                    String temp = lineString[i];
                    lineString[i] = lineString[j];
                    lineString[j] = temp;
                }
            }
        }
        //重写内容
        StringBuffer StringB=new StringBuffer();
        for(int i=0;i<lineString.length;i++){
            StringB.append(lineString[i]);
            if(i!=lineString.length-1)
                StringB.append("|");
        }
        //返回
        return StringB.toString();
    }
}
