package org.example.week3.day14;

import java.util.Random;
import java.util.UUID;

//随机数测试
public class RandomTest {
   public static void main(String[] args) {
	Random random = new Random();  //创建一个随机数对象，每次生成的随机数不同
//	int num1 = random.nextInt();  //生成一个整数的随机数
//	int num2 = random.nextInt(10);  //生成一个10以内的随机数  [0,10)
//	double d = random.nextDouble();//生成的范围是0-1.0之间
//	System.out.println(d);
	
	//如何生成一个四位校验码？Eg:Ab中c
	char[] ch = {'1','2','3','a','b','c','中','软','国','际'};
	StringBuffer sbf = new StringBuffer();  //存储四位随机数
	//4位校验码，遍历4次
	for (int i = 0; i < 4; i++) {
		//append 拼接   ch.length：数组的长度      random.nextInt( ch.length) [0,长度)----随机索引
		sbf.append(ch[random.nextInt(ch.length)]);  
	}
	System.out.println("四位校验码："+sbf);
	
	
	//UUID
//	
//	for (int i = 0; i < 10; i++) {
//		UUID uuid = UUID.randomUUID();  //唯一标识
//		System.out.println(uuid);
//	}

}
}
