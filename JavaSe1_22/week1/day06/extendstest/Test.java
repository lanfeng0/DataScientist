package org.example.week1.day06.extendstest;

class Test {
	private static int x = 10;

	public void show(int x) {
		x++;
		System.out.println(x);
	}

	public static void main(String[] args) {
		int x = 20;
		Test t = new Test();
		t.show(x);
	}
}
