package org.example.week3.day18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader读取文件中的数据
 *
 * @author Lvling
 */
public class BufferedReaderTest {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("e:\\Test.txt"));
            String str = "";
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
