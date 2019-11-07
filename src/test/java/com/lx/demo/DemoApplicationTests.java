package com.lx.demo;

import com.lx.demo.controller.FileUseController;
import com.lx.demo.utils.PdfChangeUtils;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private FileUseController fileUseController;

    //验证查询数据库功能，使用jdbctemplate 进行访问,以及打印输出的查询数据
    @Test
    public  void contextLoads() {

            String sql = "select * from user";
            List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
            for (Map<String, Object> map : list) {
                Set<Map.Entry<String, Object>> entries = map.entrySet( );
                if(entries != null) {
                    Iterator<Map.Entry<String, Object>> iterator = entries.iterator( );
                    while(iterator.hasNext( )) {
                        Map.Entry<String, Object> entry =(Map.Entry<String, Object>) iterator.next( );
                        Object key = entry.getKey( );
                        Object value = entry.getValue();
                        System.out.println(key+":"+value);
                    }
                }
            }
        }

    /**
     * 对于项目中的pdf格式文件转换为jpg格式文件
     */
    @Test
     public void pdfChangToJpg() throws InterruptedException, PDFSecurityException, PDFException, IOException {

        String pdffilepath = "D:/文件处理/影像文件处理/tar/BOSJYIM-20190806160551252663601-APPLY20190806/idcard-02.pdf";
        String jpgfilepath = "D:/文件处理/影像文件处理/tar/BOSJYIM-20190806160551252663601-APPLY20190806/idcard-02.jpg";
//		pdf2jpg(pdffilepath, jpgfilepath);

        Boolean a= PdfChangeUtils.pdf2jpg(pdffilepath,jpgfilepath);
        System.out.println("  对于pdf文件进行更改为jpg文件时候，结果为：" + a);
     }

     @Test
    public void easyErite(){

         fileUseController.writeIntoFile01();
     }




}
