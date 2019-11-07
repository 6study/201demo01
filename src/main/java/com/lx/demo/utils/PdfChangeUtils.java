package com.lx.demo.utils;

import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.util.GraphicsRenderingHints;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;

/**
 * 对于pdf格式文件进行转换为jpg文件格式
 *
 * @author LiuXue on 2019/11/6
 */
public class PdfChangeUtils {

    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    /**
     * pdf文件转jpg
     *
     * @param pdffilepath
     */
    public static Boolean  pdf2jpg(String pdffilepath, String jpgfilepath) throws IOException, PDFException, PDFSecurityException, InterruptedException {
        Document document = new Document();
        document.setFile(pdffilepath);
        float scale = 2.5f;// 缩放比例
        float rotation = 0f;// 旋转角度
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            BufferedImage image = (BufferedImage) document.getPageImage(i,
                    GraphicsRenderingHints.SCREEN,
                    org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX, rotation,
                    scale);
            RenderedImage rendImage = image;
            try {
                File file = new File(jpgfilepath);
                ImageIO.write(rendImage, "JPG", file);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            image.flush();
        }
        document.dispose();
        return  true;
    }

    /**
     * base64转pdf
     * @param base64sString
     * @param pdffilepath
     */
    public static void base64StringToPDF(String base64sString,String pdffilepath) {
        BufferedInputStream bin = null;
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        try {
            // 将base64编码的字符串解码成字节数组
            byte[] bytes = decoder.decodeBuffer(base64sString);
            // apache公司的API
            // byte[] bytes = Base64.decodeBase64(base64sString);
            // 创建一个将bytes作为其缓冲区的ByteArrayInputStream对象
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            // 创建从底层输入流中读取数据的缓冲输入流对象
            bin = new BufferedInputStream(bais);
            // 指定输出的文件http://m.nvzi91.cn/nxby/29355.html
            //File file = new File("/home/amarsoft/test.pdf");
            File file = new File(pdffilepath);
            // 创建到指定文件的输出流
            fout = new FileOutputStream(file);
            // 为文件输出流对接缓冲输出流对象
            bout = new BufferedOutputStream(fout);

            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while (len != -1) {
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            // 刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题
            bout.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bin.close();
                fout.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //删除文件
    public static boolean deleteFile(String fileName)
    {
        File file = new File(fileName);
        if(file.exists()&& file.isFile())
        {
            if(file.delete())
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException, PDFSecurityException, PDFException, IOException {
        // TODO Auto-generated method stub
        String pdffilepath = "D:/文件处理/影像文件处理/tar/BOSJYIM-20190806160551252663601-APPLY20190806/idcard-01.pdf";
        String jpgfilepath = "D:/文件处理/影像文件处理/tar/BOSJYIM-20190806160551252663601-APPLY20190806/idcard-01.jpg";
//		pdf2jpg(pdffilepath, jpgfilepath);

        Boolean a=pdf2jpg(pdffilepath,jpgfilepath);
        System.out.println("  对于pdf文件进行更改为jpg文件时候，结果为：" + a);
        //String base64 = "JVBERi0xLjQKJeLjz9MKNCAwIG9iago8PC9GaWx0ZXIvRmxhdGVEZWNvZGUvTGVuZ3RoIDg0Nj4+c3RyZWFtCnictZjPaxNBFMe3hyjsRaTgIRfHS61g252d2d2kBcGfhRIWNhtti7GVtEnAJkVLpZQURfAQjaEVJNZDD4I9eOu5B8E/wEPFQ0HQkxdB8BQRwTgzG62ifVu7LyxMJ81OPvt9837N3tDPZHRmE0Y5yUzr5zO6p5tkRP6XEkNccmSWQTJlfeACJVTMCnrvicw1ee/OLQaZKv++yDaJSXk/c4KFJknKdYb6dq6o915651/MZOcWP7fi8rcMUvzH712+Iv5Oq+eBSQZAcoeKg7WNek/+Q/EoBowmAZgfG3+TG0NDJQAUKsgBQHk7t44GskHj+Vv1hdlY5XE1VU35X1CAFgQUOEQUD0WheTw1IY/fnjnlbtZ7kGRBYRyg8GSBgSxYk1rOwdsxKLwmuhZfYTCgyHq4tbrWyubGj3tPWtl5DJqV3J3WOHdfw2BAbl4+XeL/sTcL4qaR9vL08M/vuEXMRL9FyjpPGMG0pPt7WiluZ2aw1LHa87/W7qaNUgYXrWz20OpafsDdXvp2673bfTPb632qvYxoUSo0QibN+f51lPQrQSwENEtW/MggZoQrKg4W76KAwhTVXowfvH0EIV+YtgE3Gn5sqTJaw8mFEhbSaEwsI4kCuww3nn4qZeGQwDZDxJX7rNCNpwvqNabW8zZSIVEsqB7nbbR6rFhQigpYiE4IeXwAQ6zJkriHginyME7FFNsGx7RmaoZGNVuMtpxH5YkKA4Z1m2eJkYs5x+BB4d0JHrSB2PbkHA5zjQlSUoxJQTXaF9Uohk6oxHnzbvxRs5q6OlRNYbCgU0yHNDIz5GBdmF2J153ahh9DIMFRYQlvkT5qBr6KwYOiQiorDXseBgeMhj91YexYWDRQEedMRfuOp0SOQsbgOtEpD6U2XHhVjpGaE4rsKK7z6wmk1U3NjhyfPOSMrLkPMBigUulJXHmTGqNaloedxaNrUrsH2a1D3prk4Lnf3SwdnuhC6CugwB/7mvveaHpnG817rxvN9IGopmTwewZtfb9228/TJDj4GgI56ZnC1NAZ8M7H9PPo7zwgQuWkRmeOybMmghSoqWg3T47Wp9JYn/jsRPUc2wG1KWQ77uSFkFcghaVJf1S2TTOF5bf5gT22Tj8AevEj/QplbmRzdHJlYW0KZW5kb2JqCjEgMCBvYmoKPDwvR3JvdXA8PC9TL1RyYW5zcGFyZW5jeS9UeXBlL0dyb3VwL0NTL0RldmljZVJHQj4+L0NvbnRlbnRzIDQgMCBSL1R5cGUvUGFnZS9SZXNvdXJjZXM8PC9Db2xvclNwYWNlPDwvQ1MvRGV2aWNlUkdCPj4vUHJvY1NldCBbL1BERiAvVGV4dCAvSW1hZ2VCIC9JbWFnZUMgL0ltYWdlSV0vRm9udDw8L0YxIDIgMCBSL0YyIDMgMCBSPj4+Pi9QYXJlbnQgNSAwIFIvTWVkaWFCb3hbMCAwIDU1NSAzNTBdPj4KZW5kb2JqCjYgMCBvYmoKWzEgMCBSL1hZWiAwIDM2MCAwXQplbmRvYmoKMiAwIG9iago8PC9TdWJ0eXBlL1R5cGUxL1R5cGUvRm9udC9CYXNlRm9udC9IZWx2ZXRpY2EvRW5jb2RpbmcvV2luQW5zaUVuY29kaW5nPj4KZW5kb2JqCjcgMCBvYmoKPDwvRGVzY2VudCAtMTIwL0NhcEhlaWdodCA4ODAvU3RlbVYgOTMvVHlwZS9Gb250RGVzY3JpcHRvci9GbGFncyA2L1N0eWxlPDwvUGFub3NlKAEFAgIEAAAAAAAAACk+Pi9Gb250QkJveCBbLTI1IC0yNTQgMTAwMCA4ODBdL0ZvbnROYW1lL1NUU29uZy1MaWdodC9JdGFsaWNBbmdsZSAwL0FzY2VudCA4ODA+PgplbmRvYmoKOCAwIG9iago8PC9EVyAxMDAwL1N1YnR5cGUvQ0lERm9udFR5cGUwL0NJRFN5c3RlbUluZm88PC9TdXBwbGVtZW50IDQvUmVnaXN0cnkoQWRvYmUpL09yZGVyaW5nKEdCMSk+Pi9UeXBlL0ZvbnQvQmFzZUZvbnQvU1RTb25nLUxpZ2h0L0ZvbnREZXNjcmlwdG9yIDcgMCBSL1cgWzE0WzM3NV0xNyAyNiA0NjJdPj4KZW5kb2JqCjMgMCBvYmoKPDwvU3VidHlwZS9UeXBlMC9UeXBlL0ZvbnQvQmFzZUZvbnQvU1RTb25nLUxpZ2h0LVVuaUdCLVVDUzItSC9FbmNvZGluZy9VbmlHQi1VQ1MyLUgvRGVzY2VuZGFudEZvbnRzWzggMCBSXT4+CmVuZG9iago1IDAgb2JqCjw8L0tpZHNbMSAwIFJdL1R5cGUvUGFnZXMvQ291bnQgMS9JVFhUKDIuMS43KT4+CmVuZG9iago5IDAgb2JqCjw8L05hbWVzWyhKUl9QQUdFX0FOQ0hPUl8wXzEpIDYgMCBSXT4+CmVuZG9iagoxMCAwIG9iago8PC9EZXN0cyA5IDAgUj4+CmVuZG9iagoxMSAwIG9iago8PC9OYW1lcyAxMCAwIFIvVHlwZS9DYXRhbG9nL1BhZ2VzIDUgMCBSL1ZpZXdlclByZWZlcmVuY2VzPDwvUHJpbnRTY2FsaW5nL0FwcERlZmF1bHQ+Pj4+CmVuZG9iagoxMiAwIG9iago8PC9Nb2REYXRlKEQ6MjAxNzA3MjcxODMzNTcrMDgnMDAnKS9DcmVhdG9yKEphc3BlclJlcG9ydHMgXChyZXBvcnQzMjIzXCkpL0NyZWF0aW9uRGF0ZShEOjIwMTcwNzI3MTgzMzU3KzA4JzAwJykvUHJvZHVjZXIoaVRleHQgMi4xLjcgYnkgMVQzWFQpPj4KZW5kb2JqCnhyZWYKMCAxMwowMDAwMDAwMDAwIDY1NTM1IGYgCjAwMDAwMDA5MjggMDAwMDAgbiAKMDAwMDAwMTIwNiAwMDAwMCBuIAowMDAwMDAxNjY5IDAwMDAwIG4gCjAwMDAwMDAwMTUgMDAwMDAgbiAKMDAwMDAwMTc5MyAwMDAwMCBuIAowMDAwMDAxMTcxIDAwMDAwIG4gCjAwMDAwMDEyOTQgMDAwMDAgbiAKMDAwMDAwMTQ4NSAwMDAwMCBuIAowMDAwMDAxODU2IDAwMDAwIG4gCjAwMDAwMDE5MTAgMDAwMDAgbiAKMDAwMDAwMTk0MyAwMDAwMCBuIAowMDAwMDAyMDQ4IDAwMDAwIG4gCnRyYWlsZXIKPDwvSW5mbyAxMiAwIFIvSUQgWzw2Mjg4ZWJmNDM3MjBhODgyYWU5MDFlOTgwMTdlOTczZT48NDY5MGIwYTRhMGMwNzgyOWUyNzQ1MTM4MDkxNDNkN2U+XS9Sb290IDExIDAgUi9TaXplIDEzPj4Kc3RhcnR4cmVmCjIyMDkKJSVFT0YK";
        //String ReqDate  = mTimer.getTime(2);
        //String imagePath = "D:\\\\"+"HD\\\\"+ ReqDate + "\\\\" + "123.pdf";
        //base64StringToPDF(base64,imagePath);
    }

}
