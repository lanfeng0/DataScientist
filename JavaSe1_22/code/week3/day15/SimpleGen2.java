package org.example.week3.day15;
class SimpleGen2<T> {
	private T ob;
	public SimpleGen2(T ob) {
		this.ob = ob;
	}
	public T getOb() {
		return ob;
	}
	public void setOb(T ob) {
		this.ob = ob;
	}
	public void showType() {
		System.out.println(ob.getClass().getName());
	}
	public static void main(String[] args) {
		SimpleGen2<Integer> sg = new SimpleGen2<Integer>(new Integer(99));
		sg.showType();
		Integer i = sg.getOb();
		System.out.println("value = " + i);
		SimpleGen2<String> sg2 = new SimpleGen2<String>("中软国际ETC");
		sg2.showType();
		String str = sg2.getOb();
		//Integer i1 = (Integer)sg2.getOb();//此时会检查类型安全，不符合的报编译错误
		System.out.println("value = " + str);
	}
}
