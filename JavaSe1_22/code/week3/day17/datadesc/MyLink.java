package org.example.week3.day17.datadesc;

//链表类
public class MyLink {
    private Node head;// 一个头节点引用
    // 当链表创建之初,仅仅拥有一个空的head就可以了.其内容是逐渐添加进去

    public MyLink() {
        head = null;
    }

    // 添加结点
    public void addNode(int key, int value) {
        // 1.链表为空，直接将结点添加到head中
        if (head == null) {
            head = new Node(key, value);
        } else {// 2.如果不是空，找到链表的尾部
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            // 3.在尾部添加新结点
            current.next = new Node(key, value);
        }
    }

    // 查询结点
    public int getNode(int key) {
        Node current = head;
        // 先判断查找的是不是第一个元素，是
        if (current.key == key) {
            return current.value;
        } else { // 不是
            current = head.next;
            // 查找参数的key
            while (current.key != key) {
                current = current.next;
            }
            return current.value;
        }
    }

    // 删除结点
    public boolean delNode(int key) {
        boolean flag = false;
        Node current = head; // 临时当前结点
        Node parent; // 临时前序结点
        // 1.链表是否为空--null 删除失败
        if (head == null) {
            flag = false;
        } else if (key == head.key) {// 2.不为null 是不是第一个元素 -- 是，就会做一些特殊处理
            head = head.next;
            flag = true;
        } else {// 3.不是第一个元素
            // 查找带删除结点和前序结点
            current = head.next;
            parent = head;
            while (current.key != key) {
                current = current.next;
                parent = parent.next;
            }
            // 如果找到到就删除，否则删除失败
            if (current != null) {
                parent.next = current.next;
                flag = true;
            }
        }
        return flag;
    }


    //查看所有结点信息
    public void view() {
        Node current = head;
        while (current != null) {
            System.out.println(current.key + "---------------" + current.value);
            current = current.next;
        }
    }

    //插入结点
    public boolean insertNode(Node newNode, int index) {
        Node preNode = head;
        if (preNode == null || index == 0) {
            newNode.next = preNode;
            preNode = newNode;
            return true;
        } else {
            while (preNode.next != null && index-- > 0) {
                preNode = preNode.next;
            }
            newNode.next = preNode.next;
            preNode.next = newNode;
            return true;
        }
    }

    public static void main(String[] args) {
        MyLink link = new MyLink();
        link.addNode(0, 3);
        link.addNode(1, 4);
        link.addNode(2, 5);
        link.addNode(3, 6);
//		int value = link.getNode(1);
//		System.out.println(value);
//		link.view();
//		link.delNode(2);
//		link.view();

        link.insertNode(new Node(4, 9), 4);

        link.view();

    }
}
