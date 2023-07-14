package org.example.week3.day18;

import java.io.File;

public class FileAllListTest {
    /**
     * 得到一个文件夹子下面的所有文件的名字
     *
     * @param f 文件夹
     */
    public static void listAllFile(File f) {
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                listAllFile(file);
            } else {
                System.out.println("文件名=" + file.getName());
            }
        }
    }

    public static void main(String[] args) {
        FileAllListTest.listAllFile(new File("E:\\数据挖掘"));
    }

}
