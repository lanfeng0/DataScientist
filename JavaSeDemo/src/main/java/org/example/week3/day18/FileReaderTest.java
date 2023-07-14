package org.example.week3.day18;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    public static void main(String[] args) {
        fileReaderByChar();
//        fileReader();
    }

    /**
     * 利用FileReader.read(char[] ch)方法读取数据时内容
     * 方式1，会有问题
     * 方式2，没有问题
     * 要用代码展示出来
     */
    public static void fileReaderByChar() {
        FileReader fr = null;
        try {
            fr = new FileReader("e:\\Test.txt");
            char[] ch = new char[3];    //方式1
            //char[] ch = new char[1024]; //方式2
            int num = 0;
            while ((num = fr.read(ch)) != -1) {
                System.out.println(new String(ch));  //方式1
                //System.out.println(new String(ch,0,num));//方式2
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
        }
    }

    /**
     * 利用FileReader.read()方法读取数据时内容
     */
    public static void fileReader() {
        FileReader fr = null;
        try {
            fr = new FileReader("e:\\Test.txt");
            int num = 0;
            while ((num = fr.read()) != -1) {
                System.out.println((char) num);
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
        }
    }

}
