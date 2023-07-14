package org.example.week4.day21.threadpool;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	public static void main(String[] args) {
		// 1.创建Timer对象
		Timer timer = new Timer();
		// 调用方法，安排指定的任务再执行的时间开始执行任务，并开始重复固定的工作
		//当前时间+5s后首次执行任务，并开始每隔1000毫秒执行一次任务
		timer.schedule(new NormalTask(), addOneSecond(new Date(),5), 1000);
		
		//延迟指定时间+5s后执行任务
		timer.schedule(new NormalTask(), addOneSecond(new Date(),5));
	}
	
	//在传递过来的时间的基础上加秒数
	public static Date addOneSecond(Date date,int s) {
		//获取Calendar对象
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, s);
		return calendar.getTime();
	}
	
}

// 要执行的任务
class NormalTask extends TimerTask {

	@Override
	public void run() {
		System.out.println("正常的任务"); // 定时器执行的任务
	}
}
