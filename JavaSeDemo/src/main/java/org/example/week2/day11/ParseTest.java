package org.example.week2.day11;

//类型转换 ParseXXX
public class ParseTest {
	  public static void main(String[] args) {
	    String str = "116";
	    //分别调用各个包装类的paseXxx方法对字符串进行转换，如果转换失败，将报异常
	    int i = Integer.parseInt(str);
	    short s = Short.parseShort(str);
	    byte b = Byte.parseByte(str);
	    long l = Long.parseLong(str);
	    float f = Float.parseFloat(str);
	    double d = Double.parseDouble(str);
	    System.out.println(i);
	    System.out.println(s);
	    System.out.println(b);
	    System.out.println(l);
	    System.out.println(f);
	    System.out.println(d);
	  }
	}

