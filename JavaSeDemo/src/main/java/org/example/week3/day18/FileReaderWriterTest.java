package org.example.week3.day18;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {

    public static void main(String[] args) {
        fileReaderWriter();
    }

    /**
     * 利用FileReader.read(char[] ch)方法读取数据时内容
     * 利用FileWriter.write(char[] ch)方法向文件中写数据
     */
    public static void fileReaderWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("e:\\Test.txt");
            fw = new FileWriter("e:\\Test2.txt", true);
            char[] ch = new char[1024];
            int num = 0;
            while ((num = fr.read(ch)) != -1) {
                fw.write(ch);
                fw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
