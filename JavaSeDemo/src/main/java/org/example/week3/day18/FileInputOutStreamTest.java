package org.example.week3.day18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileInputStream读取文件中的数据
 * 利用FileOutputStream向文件中写字节
 *
 * @author Lvling
 */
public class FileInputOutStreamTest {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("e:\\Test.txt");
            fos = new FileOutputStream("e:\\Test2.txt");
            int num = 0;
            byte[] b = new byte[1024];
            while ((num = fis.read(b)) != -1) {
                fos.write(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
