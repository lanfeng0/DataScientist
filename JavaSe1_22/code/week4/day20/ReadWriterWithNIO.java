package org.example.week4.day20;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadWriterWithNIO {

    public void readWriterWithNIO(File src) {
        //这段代码演示了使用NIO的FileChannel和ByteBuffer来读取文件的内容。
        //
        //首先，在readWriterWithNIO方法中，创建了一个FileInputStream和一个FileChannel来读取指定文件的内容：
        FileInputStream fis = null;
        FileChannel fileChannel = null;
        try {
            fis = new FileInputStream(src);
            fileChannel = fis.getChannel();

            //然后，创建一个容量为2的ByteBuffer对象，用于存储读取的数据：
            ByteBuffer buf = ByteBuffer.allocate(2);

            //接下来，通过调用read方法从FileChannel中读取数据，并返回读取的字节数：
            int bytesRead = fileChannel.read(buf);

            System.out.println("返回读取的字节数=" + bytesRead);
            //在一个循环中，不断读取并处理数据，直到读取的字节数为-1，表示已到达文件末尾：
            //在循环内部，首先翻转ByteBuffer，将其从写模式切换为读模式，然后通过hasRemaining方法检查是否还有剩余数据未读取，如果有，则使用get方法读取一个字节并打印。
            //在循环结束后，关闭FileChannel和FileInputStream流。
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = fileChannel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileChannel != null) {
                    fileChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            if (fis != null) {
                fis.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new ReadWriterWithNIO().readWriterWithNIO(new File("E:\\Test.txt"));
    }
}
