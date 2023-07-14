package org.example.week1.day04;

//二维数组
public class ArrayDouble {
  public static void main(String[] args) {
	   //二维数组声明
	  int [][] a1;  //推荐使用，不容易混淆
	  int []a2[]; 
	  int a3[][];  
	  
	  
	  // 数组元素类型[ ][ ] 变量名称=new 数组元素类型[一维长度] [二维长度];
	  int[][] a = new int[2][3]; //就是{{0,0,0},{0,0,0} }
	  
	  //二维数组赋值  {{1,2,3},{11,12,13}}
	  a[0][0] = 1;
	  a[0][1] = 2;
	  a[0][2] = 3;
	  a[1][0] = 11;
	  a[1][1] = 12;
	  a[1][2] = 13;
	  
	  //取值
	  System.out.println(a[1][2]);
	  
	  
	  //遍历
	  //循环的一维数组的元素
	  for(int i = 0;i<a.length;i++) {
		  //数组的元素也是数组  ，循环的是数组元素的数组
		  for(int j = 0;j<a[i].length;j++) {
			  System.out.println(a[i][j]);
		  }
	  }
	  
	  
	  //二维数组声明时，可以不指定二维的长度
	  int [][] a4 = new int [2][];
      a4[0] = new int[]{1,2,3};
      a4[1] = new int[]{4,5,6};
	  
	  System.out.println(a4[0][2]);  //3
	  System.out.println(a4[1][1]);  //2
	  
	//数组b中存储2个一维数组，每个一维数组的长度不确定
	  int[][] b=new int[2][];
	  b[0]=new int [2];
	  b[1]=new int[4];
	  //对b中的数组元素可以继续赋值
	  b[0][0]=10;
	  b[0][1]=20;
	  b[1][0]=100;
	  b[1][1]=110;
	  b[1][2]=120;
	  b[1][3]=130;

}
}
