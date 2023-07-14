package org.example.week4.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FileCopyWithNIO {
    public void saveToFileSystem(File src, File dist) {
        //这段代码演示了使用NIO的FileChannel和ByteBuffer来实现文件的复制过程。
        //首先，在saveToFileSystem方法中创建了一个FileInputStream和一个FileOutputStream，用于读取源文件和写入目标文件的数据：
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dist);

            //然后，创建了两个FileChannel，分别对应源文件和目标文件：
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            //通过调用transferTo方法将源文件的数据直接转移给目标文件的通道：这个方法会将源文件的指定范围内的数据传输到目标文件中。在这里，从位置2开始，传输源文件的数据直到结束。
            inChannel.transferTo(2, inChannel.size(), outChannel);
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new FileCopyWithNIO().saveToFileSystem(new File("E:\\Test.txt"), new File("E:\\Test3.txt"));
    }
}
