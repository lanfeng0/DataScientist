package org.example.week3.day14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

//日期测试
public class DateTest {
public static void main(String[] args) {
//	dateTest();
	Date date = new Date();  //获取系统时间
    
    System.out.println(ChangeDateUtils.stringToDate("2018-2-1 12:12:12"));
    date = ChangeDateUtils.addYear(date, 1);
    date = ChangeDateUtils.addMonth(date, 1);
    date = ChangeDateUtils.addDay(date, 3);
    System.out.println(date);
    date = ChangeDateUtils.addWeek(date, 1);
    
    System.out.println(ChangeDateUtils.dateToString(date));
    
}

private static void dateTest() {
	//1.获取当前的系统时间
	Date date = new Date();
	System.out.println(date);
	
	//2.日历
    Calendar calendar =  Calendar.getInstance();  //使用默认时区和区域设置获取日历。	
    calendar.set(Calendar.YEAR, 2021);  //设置年
    calendar.set(2019, 7, 20, 10, 15, 34);  //设置时分秒，年月日
    calendar.add(Calendar.YEAR, 1);  //年份+1
    System.out.print(calendar.get(Calendar.YEAR)+"年");
    System.out.print(calendar.get(Calendar.MONTH)+1+"月");   //0-11
    System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"日");
    System.out.print(calendar.get(Calendar.HOUR)+"时");
    System.out.print(calendar.get(Calendar.MINUTE)+"分");
    System.out.print(calendar.get(Calendar.SECOND)+"秒");
    System.out.println("星期"+(calendar.get(Calendar.DAY_OF_WEEK)-1)); //星期-1
    
    Date date2 = calendar.getTime();  //转回日期类型
    System.out.println(date2);
    
    /*
  (1)SimpleDateFormat中定义了对时间进行格式化的方法
  (2)SimpleDateFormat(String pattern) 	使用模式字符串创建对象；
  (3)String format(Date date)	把date进行格式化； 
  (4)public Date parse(String source) throws ParseException     把字符串转换成Date对象，如果格式不匹配抛出转换异常
     */
    //3.格式转换
    //Date---String类型  格式
    
    SimpleDateFormat df1  = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");   //创建对象，并且规范转换后的格式
    String dateToString =  df1.format(date);  //把Date转成String类型
    System.out.println(dateToString);
    
    //String类型---Date类型
    SimpleDateFormat df2  = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");   //创建对象，并且规范转换后的格式
    String dateStr = "2020年6月12日10时12分12秒";  //SimpleDateFormat定义的格式必须和此字符串格式一致
    
    try {
		Date strToDate = df2.parse(dateStr);  // 把字符串转成Date类型
		System.out.println(strToDate);
	} catch (ParseException e) {
		e.printStackTrace();
	}

    
    LocalDate localDate = LocalDate.now();  //从默认时区的系统时钟获取当前日期对象
    System.out.println(localDate.getYear()+"年"+localDate.getMonthValue()+"月"+localDate.getDayOfMonth()+"日");

    //字符串转换--LocalDate
    String str="2001-09-12";
    LocalDate date3 =  LocalDate.parse(str);  
    System.out.println(date3);
    
    //LocalDate---字符串转换
    String localDateToStr =  date3.toString();
    System.out.println(localDateToStr);   
    
    LocalTime localTime  = LocalTime.now();  //从默认时区的系统时钟获取当前时间。 
    System.out.println(localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond());
    
    //字符串转换---LocalTime
    String strTime = "12:12:12";
    LocalTime date4 = LocalTime.parse(strTime);
    System.out.println(date4);
    
    //LocalTime--字符串转换
    String localTimeToStr = date4.toString();
    System.out.println(localTimeToStr);
}
}
