package org.example.week2.day13.assertion;

//断言测试
public class TestAssertion {
    private   static void test(int i){
		assert i!=1:"输入值不能为1";
		System.out.println("i="+i);
	}
	public static void main(String[] args) {
		test(2);
		test(1);

		int result = new TestAssertion().divide(10, 0); // 正常情况下，断言不会触发错误
		System.out.println(result);
	}
	public int divide(int a, int b) {
		assert b != 0 : "除数不能为零";
		return a / b;
	}

}

