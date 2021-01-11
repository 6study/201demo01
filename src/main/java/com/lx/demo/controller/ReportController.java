package com.lx.demo.controller;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基础报表
 *
 * @author LiuXue on 2020/12/14
 */
@RestController
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);


    /**
     * 实现基础报表excel文件的创建 【xlsx】
     */
    public void makeOriExcel(){

        File file = null;
        FileOutputStream fOut = null;
        String fileName = "D:/myFile/A/ori报表";
        String sendfileName = "D:/myFile/B/ori报表";
        try {
            file = new File(new String(fileName.getBytes("utf-8")));// 创建excel文件对象 -防止乱码 默认utf-8
            if(!file.exists()){
                file.createNewFile();
                // 创建一个新的HSSFWorkbook对象
                HSSFWorkbook workbook = new HSSFWorkbook();

                // 创建一个Excel的工作表，指定工作表的名字
                HSSFSheet sheet = workbook.createSheet("sheet1");

                int rowNum = 0;// 行标
                int colNum = 0;// 列标
                // 建立表头信息
                HSSFRow row = null;
                HSSFCell cell = null;
                for (; rowNum < 2; rowNum++) {
                    // 新建第rowNum行
                    row = sheet.createRow(rowNum);
                    for (colNum = 0; colNum < 8; colNum++) {
                        // 在当前行的colNum位置创建单元格
                        row.createCell(colNum);
                    }
                }

                CellRangeAddress region = new CellRangeAddress(0, 0, 0, 7);
                sheet.addMergedRegion(region);
                // 获得第一个大单元格
                cell = sheet.getRow(0).getCell(0);
                HSSFCellStyle cellStyle = workbook.createCellStyle();
                cellStyle.setBorderBottom(BorderStyle.THIN);
                cellStyle.setBorderLeft(BorderStyle.THIN);
                cellStyle.setBorderRight(BorderStyle.THIN);
                cellStyle.setBorderTop(BorderStyle.THIN);
                cellStyle.setAlignment(HorizontalAlignment.CENTER);
                cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                HSSFFont font = workbook.createFont();
                font.setFontName("宋体");
                font.setFontHeightInPoints((short)20);
                cellStyle.setFont(font);
                cell.setCellStyle(cellStyle);
                cell.setCellValue("基础报表");

                RegionUtil.setBorderBottom(BorderStyle.THIN,region,sheet);
                RegionUtil.setBorderLeft(BorderStyle.THIN,region,sheet);
                RegionUtil.setBorderRight(BorderStyle.THIN,region,sheet);
                RegionUtil.setBorderTop(BorderStyle.THIN,region,sheet);

                HSSFCellStyle cellStyle2 = workbook.createCellStyle();
                cellStyle2.setWrapText(true);
                cellStyle2.setBorderBottom(BorderStyle.THIN);
                cellStyle2.setBorderLeft(BorderStyle.THIN);
                cellStyle2.setBorderRight(BorderStyle.THIN);
                cellStyle2.setBorderTop(BorderStyle.THIN);
                cellStyle2.setAlignment(HorizontalAlignment.CENTER);
                cellStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
                HSSFFont font5 = workbook.createFont();
                font5.setFontName("宋体");
                font5.setFontHeightInPoints((short)10);
                cellStyle2.setFont(font5);
                cell = sheet.getRow(1).getCell(0);
                cell.setCellStyle(cellStyle2);
                cell.setCellValue("操作日期");

                cell = sheet.getRow(1).getCell(1);
                cell.setCellStyle(cellStyle2);
                cell.setCellValue(new HSSFRichTextString("001项\r\n" +
                        "细则"));

                cell = sheet.getRow(1).getCell(2);
                cell.setCellStyle(cellStyle2);
                cell.setCellValue(new HSSFRichTextString("002项"));

                cell = sheet.getRow(1).getCell(3);
                cell.setCellStyle(cellStyle2);
                cell.setCellValue(new HSSFRichTextString("003项"));

                cell = sheet.getRow(1).getCell(4);
                cell.setCellStyle(cellStyle2);
                cell.setCellValue(new HSSFRichTextString("004项"));

                cell = sheet.getRow(1).getCell(5);
                cell.setCellStyle(cellStyle2);
                cell.setCellValue(new HSSFRichTextString("005项"));

                cell = sheet.getRow(1).getCell(6);
                cell.setCellStyle(cellStyle2);
                cell.setCellValue(new HSSFRichTextString("006项"));

                cell = sheet.getRow(1).getCell(7);
                cell.setCellStyle(cellStyle2);
                cell.setCellValue(new HSSFRichTextString("007项"));

                //宽度自适应
                sheet.autoSizeColumn(0, true);
                sheet.autoSizeColumn(1, true);
                sheet.autoSizeColumn(2, true);
                sheet.autoSizeColumn(3, true);
                sheet.autoSizeColumn(4, true);
                sheet.autoSizeColumn(5, true);
                sheet.autoSizeColumn(6, true);
                sheet.autoSizeColumn(7, true);

                row = sheet.createRow((short) rowNum);
                row.createCell(0).setCellValue("合计");
                row.createCell(1);
                row.createCell(2);
                row.createCell(3);
                row.createCell(4);
                row.createCell(5);
                row.createCell(6);
                row.createCell(7);

                // 新建一输出文件流
                fOut = new FileOutputStream(file);
                // 将创建的内容写到指定的Excel文件中
                workbook.write(fOut);
                fOut.flush();
                fOut.close();
                logger.info("Excel文件创建成功！\nExcel文件的存放路径为：【{}】", file.getAbsolutePath());
            }
            logger.info("拷贝文件开始");
            FileUtils.copyFile(file, new File(sendfileName));
            logger.info("拷贝文件结束");
        } catch (Exception e) {
            logger.error("Excel文件" + file.getAbsolutePath()
                    + "创建失败\n其原因为：【{}】" + e);
        } finally {
            if (fOut != null) {
                try {
                    fOut.close();
                } catch (IOException e1) {
                    logger.error("关闭文件输出流失败{}", e1.getMessage());
                }
            }
        }



    }



}
