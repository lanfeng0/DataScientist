package org.example.week1.day05;

//计算成绩
public class ScoreCalc {
   //计算总成绩的方法    返回值 有 double   参数 有 3个double   做什么 ？加运算
	public double culTotalScore(double javaScore,double cScore,double dbScore) {
		double totalScore = javaScore+cScore+dbScore;
		return totalScore;
	}
   //计算平均分的方法  返回值 double   参数 1 double    做什么/3
	public double culAvg(double totalScore) {
		double avg = totalScore/3;
		return avg;
	}
	
}
