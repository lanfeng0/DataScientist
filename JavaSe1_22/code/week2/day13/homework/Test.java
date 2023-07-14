package org.example.week2.day13.homework;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------超市计价系统----------");
		Market[] m = new Market[3];
		Market n = new Market();
        double  totalPrice = 0;  //计算总金额
		
		while (true) {
			System.out.println("编号\t商品\t价格");
			m[0] = new Market(1, "可口可乐", 3);
			m[1] = new Market(2, "爆米花", 5);
			m[2] = new Market(3, "益达", 10);
			for (int i = 0; i < m.length; i++) {
				System.out.println(m[i]);
			}
			System.out.println("请输入购买的商品编号：");
			int id = sc.nextInt();
			System.out.println("请输入购买的商品数量：");
			int num = sc.nextInt();
			double price = 0;
			for (Market market : m) {
				if (id == market.getId()) {
					price = market.getPrice();
				}
			}
			totalPrice+=n.calc(price, num);  //累计小计
			System.out.println("小计：" + n.calc(price, num) + "￥");
			System.out.println("是否继续购物 y/n");
			String selected = sc.next();
			if(selected.equals("n")) {  //如果选择n，结束循环
				break;
			}
		}
		
		System.out.println("一共消费："+totalPrice);
		
	}
}
