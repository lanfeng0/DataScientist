package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

public class GbkFileToUtf8Batch {
    public static void main(String[] args) throws Exception{
        //获取所有java文件
        Collection<File> javaGbkFileCol =  FileUtils.listFiles(new File("E:\\"), new String[]{"java"}, true);

        for (File javaGbkFile : javaGbkFileCol) {
            //UTF8格式文件路径
            String utf8FilePath = "E:\\"+javaGbkFile.getAbsolutePath().substring("E:\\".length());
            System.out.println(utf8FilePath);
            //使用GBK读取数据，然后用UTF-8写入数据
            FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(javaGbkFile, "GBK"));
        }

        System.out.println("批量编码完成.....");
    }
}
