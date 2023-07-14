package org.example.week2.day09.bookshop.ui;

import org.example.week2.day09.bookshop.dao.UserDaoImpl;
import org.example.week2.day09.bookshop.entity.UserEntity;

import java.util.Scanner;

//测试类
//技术：流程控制+运算符+局部变量+调用方法+创建对象
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		UserDaoImpl userDao = new UserDaoImpl();  //要想使用一个类的方法，就需要创建该类的对象
		loop1: while(true) {
			System.out.println("欢迎登入图书商城\n"
					+ "1.登录 \t 2.退出\n"
					+ "请选择：");
			int selected = sc.nextInt();
			if(selected == 1) {  //选择登录
				System.out.println("请输入用户名:");
				String userName = sc.next();
				System.out.println("请输入密码:");
				String pwd = sc.next();
				//调用UserDao中的登入方法,得到UserEnity对象
				UserEntity user = userDao.login(userName, pwd);
				if(user!=null) {  //user不等于null 登录成功  等于null--失败
					System.out.println("登录成功");
					loop2: while(true) {
						System.out.println("欢迎登入图书商城\n"
								+ "1.修改密码  2.查看所有用户  3.查看所有图书信息  4.退出登入  5.退出系统"
								+ "请选择：");
						int temp = sc.nextInt();
						if(temp==1) {
							System.out.println("请输出新密码:");
							String newPwd1 = sc.next();
							System.out.println("请输出重复新密码:");
							String newPwd2 = sc.next();
							//调用修改密码的方法
							boolean result  = userDao.updatePwd(user, newPwd1, newPwd2);
							System.out.println(result==true?"修改成功":"修改失败");
							continue;
						}else if(temp == 4) {
							break loop2; //退出当前的循环
						}else {
							break loop1; //退出整个循环
						}
					} 
				}else {
					System.out.println("您输入的账户名或者密码错误，请重新登入");
					continue;
				}
			}else {  //退出
				System.out.println("退出系统，欢迎您下次登录");
				break loop1;
			}
		}
		
	}

}
