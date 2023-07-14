package org.example.week3.day18;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 利用FileOutputStream向文件中写字节
 *
 * @author BlueZ
 */
public class FileOutputStreamTest {

    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("e:\\Test.txt");
            fos.write(97);
            fos.write("abc".getBytes());
            //字节流不用刷新，FileOutputStream虽然也有flush方法，但方法里是空的
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
        }
    }
}
