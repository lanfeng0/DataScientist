package org.example.week2.day07.oa.oop02;
//导入外部包的某一个类--TestStudent类，否则无法使用
//import com.etc.oa.oop01.TestStudent;
//导入外部包的所有类

import org.example.week2.day07.oa.oop01.TestScore;
import org.example.week2.day07.oa.oop01.TestStudent;
//导包测试
public class TestTeacher {
	public static void main(String[] args) {
		TestStudent student = new TestStudent();
		student.show();
		TestScore testScore = new TestScore();
	}
}
