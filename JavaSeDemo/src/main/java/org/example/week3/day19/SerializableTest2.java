package org.example.week3.day19;

import java.io.*;

public class SerializableTest2 {
    public static void main(String[] args) throws Exception {
        example1();
        example2();
    }

    /**
     * 把对象序列化写入硬盘方式，在反序列化出来
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void example1() throws IOException, ClassNotFoundException {
        // 对象的序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\person2.obj"));
        Person2 person = new Person2("Tom", 40, "China");
        oos.writeObject(person);
        oos.close();
        // 对象的反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\person2.obj"));
        Person2 person2 = (Person2) ois.readObject();
        System.out.println("反序列化=" + person2);
        System.out.println("序列化=" + person);
        System.out.println(person == person2);
    }

    /**
     * 把对象序列化写入数组方式，在反序列化出来
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void example2() throws IOException, ClassNotFoundException {
        // 对象的序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        Person2 person = new Person2("Jerry", 30, "Beijing");
        oos.writeObject(person);
        byte[] buffer = baos.toByteArray();
        oos.close();
        baos.close();
        // 对象的反序列化
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(
                buffer));
        Person2 person2 = (Person2) ois.readObject();
        System.out.println(person2);
        System.out.println(person);
        System.out.println(person == person2);
    }

}
