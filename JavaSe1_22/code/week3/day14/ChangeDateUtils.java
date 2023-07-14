package org.example.week3.day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//日期类工具
public class ChangeDateUtils {
  
	/**
	 * 提供把日期类型转成String类型的方法
	 * @param date
	 * @return   String类型
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  //格式
		return df.format(date);  //转换
	} 
	
	/**
	 * 提供把字符串转成日期类型的方法
	 * @param str
	 * @return  Date类型
	 * 格式必须是：yyyy-MM-dd hh:mm:ss
	 */
	public static Date stringToDate(String str) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  //格式
		Date date = null;
		try {
			date = df.parse(str);  //转换
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 提供一个增加天数的方法
	 * @param date
	 * @param day
	 * @return  
	 */
	public static Date addDay(Date date ,int day) {
		Calendar calendar = Calendar.getInstance();  //获取日历对象
		calendar.setTime(date);  //给当前日历对象设置传递过来的日期时间 
		calendar.add(Calendar.DATE, day);  //给日期，添加天数
		date = calendar.getTime();  //获取日期类型
		return date;
	}
	
	/**
	 * 提供一个增加月份的方法
	 * @param date
	 * @param month
	 * @return  
	 */
	public static Date addMonth(Date date ,int month) {
		Calendar calendar = Calendar.getInstance();//获取日历对象
		calendar.setTime(date);//给当前日历对象设置传递过来的日期时间 
		calendar.add(Calendar.MONTH, month); //给日期，添加月
		date = calendar.getTime();//获取日期类型
		return date;
	}
	
	/**
	 * 提供一个增加年的方法
	 * @param date
	 * @param year
	 * @return  
	 */
	public static Date addYear(Date date ,int year) {
		Calendar calendar = Calendar.getInstance();//获取日历对象
		calendar.setTime(date);//给当前日历对象设置传递过来的日期时间 
		calendar.add(Calendar.YEAR, year); //给日期，添加年
		date = calendar.getTime();//获取日期类型
		return date;
	}
	
	
	/**
	 * 提供一个增加星期的方法
	 * @param date
	 * @param week
	 * @return  
	 */
	public static Date addWeek(Date date ,int week) {
		Calendar calendar = Calendar.getInstance();//获取日历对象
		calendar.setTime(date);//给当前日历对象设置传递过来的日期时间 
		calendar.add(Calendar.WEEK_OF_MONTH, week);//给日期，添加星期
		date = calendar.getTime();//获取日期类型
		return date;
	}
	
}
