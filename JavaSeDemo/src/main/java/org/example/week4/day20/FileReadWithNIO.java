package org.example.week4.day20;

import java.nio.ByteBuffer;

public class FileReadWithNIO {

    public void readFileSystem() {
        // 在readFileSystem方法中创建了一个容量为11的ByteBuffer对象：
        ByteBuffer buffer = ByteBuffer.allocate(11);
		//将字符串"hello"转换为字节数组，并将字节数组写入ByteBuffer中：
        buffer.put("hello".getBytes());
		//接下来，通过打印语句展示了ByteBuffer的容量、限制和位置信息：
        System.out.println("capacity:" + buffer.capacity() + ",limit:"
                + buffer.limit() + ",position:" + buffer.position());
        // capacity表示ByteBuffer的总容量，limit表示当前写入的字节数，position表示下一个写入的位置。
		//
		//通过调用flip()方法翻转Buffer的位置和限制，准备进行读取操作：
        buffer.flip();
		//然后使用循环遍历Buffer中的数据并打印出来：
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.println((char) buffer.get(i));
        }
    }

    public static void main(String[] args) {
        new FileReadWithNIO().readFileSystem();
    }
}
