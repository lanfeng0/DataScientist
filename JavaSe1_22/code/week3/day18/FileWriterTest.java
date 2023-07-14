package org.example.week3.day18;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 利用FileWriter向文件中写入字符,并且用了换行符
 *
 * @author Lvling
 *
 */
public class FileWriterTest {
    // 定义换行符
    private static final String LIN_SEPARATOR = System
            .getProperty("line.separator");

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("e:\\Test.txt", true);
            // 加入换行符
            fw.write(97 + LIN_SEPARATOR);
            fw.write("abc" + LIN_SEPARATOR);
            char[] b = { 'a', 'b', 'c' };
            fw.write(b);
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {

                try {
                    fw.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }

        }

    }

}
