package org.example.week3.day18;

import java.io.FileInputStream;

/**
 * FileInputStream读取文件中的数据
 *
 * @author BlueZ
 */
public class FileInputStreamTest {

    public static void main(String[] args) {
        fileInputStreamByread();
    }

    public static void fileInputStreamByreadChar() {
        try {
            FileInputStream fis = new FileInputStream("e:\\log.txt");
            int num = 0;
            byte[] b = new byte[11024];
            while ((num = fis.read(b)) != -1) {
                System.out.println(new String(b, 0, num));
            }
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    /**
     * FileInputStream 中的read()方法读取文件中的数据
     */
    public static void fileInputStreamByread() {

        try {
            FileInputStream fis = new FileInputStream("e:\\Test.txt");
            int num = 0;
            while ((num = fis.read()) != -1) {
                // 读一个打印一个
                System.out.println((char) num);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
