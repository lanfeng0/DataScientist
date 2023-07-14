package org.example.week3.day18;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("e:\\Text.txt");
        String name = file.getName();
        String abspath = file.getAbsolutePath();
        long len = file.length();
        long time = file.lastModified();
        Date d = new Date(time);
        DateFormat df = DateFormat.getDateTimeInstance();
        String date = df.format(d);
        System.out.println(name + "," + abspath + "," + len + "," +time+","+ date);
    }
}
