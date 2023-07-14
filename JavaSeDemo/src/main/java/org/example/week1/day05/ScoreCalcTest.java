package org.example.week1.day05;

import java.util.Scanner;

//计算成绩的测试类
public class ScoreCalcTest {
	
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("请输入java成绩:");
	double javaScore = sc.nextDouble();
	System.out.println("请输入c成绩:");
	double cScore = sc.nextDouble();
	System.out.println("请输入DB成绩:");
	double dbScore = sc.nextDouble();
	
	//必须创建对象 ，
	ScoreCalc c1 = new ScoreCalc();
	//通过对象调用方法
	double totalScore =  c1.culTotalScore(javaScore, cScore, dbScore);
	//调用计算平均分的方法
	double avg = c1.culAvg(totalScore);
	System.out.println("总成绩："+totalScore+"\t平均分:"+avg);
}
}
