package org.example.week2.day09.bookshop.dao;

import org.example.week2.day09.bookshop.entity.UserEntity;

//系统初始化数据   模拟数据数据
//技术：数组+数组元素是U对象 +静态块+公有方法(返回数组)+返回值是数组+属性是引用数据类型
//1.声明数组 
//2.静态块中创建多个用户对象赋值到数组
//3.写一个getUsers    
public class BaseData {
  //声明数组，元素类型是UserEntity对象  ，可以存储10个对象
  static UserEntity[] users = new UserEntity[10];
  static {
	  //创建多个UserEntity对象
	  UserEntity user1 = new UserEntity(1, "alice", "123456");
	  UserEntity user2 = new UserEntity(2, "lily", "123456");
	  UserEntity user3 = new UserEntity(3, "tom", "123456");
	  //存放到数组
	  users[0] = user1;
	  users[1] = user2;
	  users[2] = user3;
	  
  }
  
//  提供一个公有方法  返回存有所有用户的数组  返回值是引用类型(数组)    
  public  UserEntity[] getUsers() {
	  return users;
  }
  
}
