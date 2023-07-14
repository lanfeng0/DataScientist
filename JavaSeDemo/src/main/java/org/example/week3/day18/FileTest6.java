package org.example.week3.day18;

import java.io.File;

public class FileTest6 {

    public static void main(String[] args) {
        try {
            //===list() 列出users文件夹下面的所有文件及文件夹，包含隐藏文件
            File f = new File("c:\\users\\");
            String[] strs = f.list();
            for (String s : strs) {
                System.out.println(s);
            }
            //如果访问的是c盘下的系统级文件夹，会报空指针
            File f1 = new File("c:\\users\\周路\\");
            //如果访问的是文件夹是空的，那返回的数组长度是0
            File f2 = new File("c:\\a\\");
            //======listFiles()========================
            File f3 = new File("c:\\users\\");
            File[] files = f3.listFiles();
            for (File file : files) {
                System.out.println("列出usrs文件夹里内容的名字=" + file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
