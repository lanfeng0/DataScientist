package org.example.week2.day09.implementdemo;

public class PersonTest {
    public static void main(String[] args) {
        Chinese chinese = new Chinese();
        American american = new American();

        PersonTest test = new PersonTest();
        test.print(chinese);
        test.print(american);
    }

    public void print(Person p) {  //多态  声明的是接口，实际传递的是实现类
        p.say();
        p.foo();  //可以直接调用默认方法
    }
}
