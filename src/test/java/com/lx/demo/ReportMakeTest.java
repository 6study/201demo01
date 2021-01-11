package com.lx.demo;

import com.lx.demo.controller.ReportController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 报表处理
 *
 * @author LiuXue on 2020/12/14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReportMakeTest {

    @Autowired
    private ReportController reportController;

    @Test
    public void makeReport(){

        reportController.makeOriExcel();

    }
}
