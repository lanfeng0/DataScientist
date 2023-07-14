package org.example.week4.day21.communcation;

public class ProCusTest {
  public static void main(String[] args) {
	Product p = new Product() ; //创建产品类对象
	Producer producer = new Producer(p);  //创建了生产者线程对象
	Customer customer = new Customer(p);  //创建了消费者线程对象
	producer.start();
	customer.start();
}
}
