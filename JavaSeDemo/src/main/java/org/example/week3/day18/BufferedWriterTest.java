package org.example.week3.day18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter向文件中写入数据
 *
 * @author Lvling
 */
public class BufferedWriterTest {

    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("e:\\Test.txt"));
            for (int i = 0; i < 4; i++) {
                bw.write("abc" + i);
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }
    }

}
