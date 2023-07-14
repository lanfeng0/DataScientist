package org.example.week3.day17.datadesc;

//链表的结点类
public class Node {
    //两个int型的数据  表示链表结点实际要存储的内容(可自己定义)
    int key;
    int value;
    Node next;  //指向下一个结点的引用

    //有参数的构造方法
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
