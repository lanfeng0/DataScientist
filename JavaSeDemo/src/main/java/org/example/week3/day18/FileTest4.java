package org.example.week3.day18;

import java.io.File;

public class FileTest4 {

    public static void main(String[] args) {
        try {
            //获取盘符
            File[] files = File.listRoots();
            for (File f : files) {
                System.out.println("盘符=" + f);
            }
            //获取盘符属性
            File f = new File("e:\\");
            long freeSpace = f.getFreeSpace();
            long totalSpace = f.getTotalSpace();
            long useSpace = f.getUsableSpace();
            System.out.println("剩余空间=" + freeSpace + "可用空间=" + useSpace + "总容量=" + totalSpace);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
