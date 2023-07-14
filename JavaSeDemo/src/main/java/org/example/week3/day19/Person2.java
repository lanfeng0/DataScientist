package org.example.week3.day19;

import java.io.*;

public class Person2 implements Serializable {
    private String name;
    private int age;
    private String address;

    /**
     * 这是一个示例的自定义序列化和反序列化方法。在Java中，可以通过实现java.io.Serializable接口，并定义private void writeObject(ObjectOutputStream out)和private void readObject(ObjectInputStream in)方法来自定义对象的序列化和反序列化过程。
     *
     * 在上述代码中，writeObject(ObjectOutputStream out)方法用于自定义对象的序列化过程，readObject(ObjectInputStream in)方法用于自定义对象的反序列化过程。
     *
     * writeObject(ObjectOutputStream out)方法的实现：
     *
     * 首先调用out.defaultWriteObject()，默认序列化对象的非静态和非瞬态字段。
     * 然后调用out.writeUTF(address)，将address属性以UTF-8编码写入输出流。
     * readObject(ObjectInputStream in)方法的实现：
     *
     * 首先调用in.defaultReadObject()，默认反序列化对象的非静态和非瞬态字段。
     * 然后调用in.readUTF()，从输入流中以UTF-8编码读取数据，并将其赋值给address属性。
     * 通过自定义writeObject()和readObject()方法，可以在序列化和反序列化过程中执行一些特定的逻辑，如加密、压缩等。此外，还可以控制序列化和反序列化哪些字段，例如跳过敏感字段的序列化。
     *
     * 需要注意以下几点：
     *
     * 自定义的序列化方法和反序列化方法必须是private的。
     * 方法签名必须与示例代码中的一致。
     * 自定义的方法必须抛出IOException和ClassNotFoundException。
     * @param out
     * @throws IOException
     */
    //不用transient来修饰，用 writeObject()与readObject()这二个方法实现序列化
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeUTF(address);
    }

    private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        address = in.readUTF();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person2(String name, int age, String address) {
        System.out.println("Person构造方法");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "[Person:" + name + "," + age + "," + address + "]";
    }

}
