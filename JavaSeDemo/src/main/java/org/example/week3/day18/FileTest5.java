package org.example.week3.day18;

import java.io.File;

public class FileTest5 {
    public static void main(String[] args) {
        try {
            //重命名
            File f1 = new File("e:\\a.txt");
            File f2 = new File("e:\\b.txt");
            //将a.txt重命名成b.txt
            boolean b1 = f1.renameTo(f2);
            System.out.println(b1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
