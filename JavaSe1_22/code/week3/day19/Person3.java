package org.example.week3.day19;

import java.io.*;

//序列化接口Externalizable
public class Person3 implements Externalizable {
    private String name;
    private int age;
    private String address;

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

    public Person3(String name, int age, String address) {
        System.out.println("Person构造方法");
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Person3() {
    }

    //重写序列化接口Externalizable接口中的方法来自定义序列化
    @Override
    public void readExternal(ObjectInput arg0) throws IOException,
            ClassNotFoundException {
        System.out.println("自定义序列化过程");
        name = arg0.readUTF();
        //可以序列化进去，我这里也可以选择不读，那反序列化出来的就是0默认值
        age = arg0.readInt();
        address = arg0.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput arg0) throws IOException {
        System.out.println("自定义反序列化过程");
        arg0.writeUTF(name+"ext");
        arg0.writeInt(age + 10);
        arg0.writeUTF(address + "ext");
    }


    @Override
    public String toString() {
        return "[Person:" + name + "," + age + "," + address + "]";
    }

}
