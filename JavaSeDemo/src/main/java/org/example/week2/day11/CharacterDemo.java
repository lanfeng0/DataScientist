package org.example.week2.day11;

//Character类的常用方法示例
public class CharacterDemo {
	  public static void main(String[] args) {
	    char[] charArray = {'*', '7', 'b', ' ', 'A'};
	    for (int i = 0; i < charArray.length; i++) {
	      if (Character.isDigit(charArray[i])) {
	        System.out.println(charArray[i] + "是一个数字。");
	      }
	     if (Character.isLetter(charArray[i])) {
	        System.out.println(charArray[i] + "是一个字母。");
	      }
	      if (Character.isWhitespace(charArray[i])) {
	        System.out.println(charArray[i] + "是一个空格。");
	      }
	      if (Character.isLowerCase(charArray[i])) {
	        System.out.println(charArray[i] + "是小写形式。");
	      }
	      if (Character.isUpperCase(charArray[i])) {
	        System.out.println(charArray[i] + "是大写形式。");
	      }
	    }
	  }
	}

