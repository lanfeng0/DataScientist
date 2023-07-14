package org.example.week4.day20;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class FileWriterWithNIO {

    public void writerWithNIO() {

        //这段代码演示了使用NIO（New I/O）的ByteBuffer来进行写操作的过程。
        //
        //首先，在writerWithNIO方法中创建了一个容量为11的ByteBuffer对象：
        ByteBuffer buffer = ByteBuffer.allocate(11);

        //然后，将字符串"hello"转换为字节数组，并将字节数组写入ByteBuffer中：
        buffer.put("hello".getBytes());
        //接下来，通过打印语句展示了ByteBuffer的容量、限制和位置信息：
        System.out.println("capacity:" + buffer.capacity() +
                ",limit:" + buffer.limit() +
                ",position:" + buffer.position());

        //接着，通过调用flip()方法翻转Buffer的位置和限制，准备进行读取操作：
        buffer.flip();

        //然后创建一个长度为10的字节数组，并将ByteBuffer中的数据复制到这个字节数组中：
        byte[] bytes1 = new byte[10];
        bytes1 = buffer.array();
        //最后，将字节数组中的数据转换成字符串并打印出来：
        System.out.println(new String(bytes1));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        new FileWriterWithNIO().writerWithNIO();
    }
}
