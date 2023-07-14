package org.example.week3.day18;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 利用BufferedInputStream读取文件中的数据 利用BufferedOutputStream向文件中写字节
 *
 * @author Lvling
 */
public class BufferedInputOutStreamTest {

    public static void main(String[] args) {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("e:\\a.jpg"));
            bos = new BufferedOutputStream(new FileOutputStream("e:\\b.jpg"));
            int num = 0;
            byte[] b = new byte[1024];
            while ((num = bis.read(b)) != -1) {
                bos.write(b);
                bos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
