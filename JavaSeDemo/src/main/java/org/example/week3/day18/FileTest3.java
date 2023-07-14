package org.example.week3.day18;

import java.io.File;

public class FileTest3 {
    public static void main(String[] args) {
        try {
            File file = new File("e:\\Text.txt");
            boolean isExit = file.exists();
            boolean isFile = file.isFile();
            boolean isDir = file.isDirectory();
            System.out.println("存在吗：" + isExit + ",是文件吗：" + isFile + ",是文件夹吗：" + isDir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

