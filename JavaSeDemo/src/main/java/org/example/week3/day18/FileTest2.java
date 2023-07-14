package org.example.week3.day18;

import java.io.File;
import java.io.IOException;

public class FileTest2 {

    public static void main(String[] args) {
        try {
            File file1 = new File("e:\\Text.txt");
            //创建成功返回true，否则返回false，若文件不存 则创建，如果文件存在则不创建
            boolean b = file1.createNewFile();
            System.out.println(b);
            boolean d = file1.delete();
            System.out.println(d);
            File file2 = new File("e:\\a1");
            file2.mkdir();
            File file3 = new File("e:\\a\\b\\c");
            file3.mkdirs();
            //  如果直接删除a文件夹，返回false，要先从里向外删除
            System.out.println(file2.delete());//返回false
            File file4 = new File("e:\\a\\b\\c");
            System.out.println(file4.delete());
            File file5 = new File("e:\\a\\b\\");
            System.out.println(file5.delete());
            File file6 = new File("e:\\a\\");
            System.out.println(file6.delete());
            //如果文件夹里有文件会回false，不让删除，如果想要删除，那就从里向外删除
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
