package org.example.week3.day19;

import java.io.Serializable;

public class Person1 implements Serializable {
    private String name;
    private int age;
    //字段被声明为transient后，默认序列化机制就会忽略该字段
    private transient String address;

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

    public Person1(String name, int age, String address) {

        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "[Person:" + name + "," + age + "," + address + "]";
    }

}
