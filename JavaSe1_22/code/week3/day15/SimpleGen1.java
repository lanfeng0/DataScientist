package org.example.week3.day15;
class SimpleGen1 {
	private Object ob;
	public SimpleGen1(Object ob) {
		this.ob = ob;
	}
	public Object getOb() {
		return ob;
	}
	public void setOb(Object ob) {
		this.ob = ob;
	}
	public void showType() {
		System.out.println(ob.getClass().getName());
	}
	public static void main(String[] args) {
		SimpleGen1 sg = new SimpleGen1(new Integer(99));
		sg.showType();
		Integer i = (Integer) sg.getOb();
		System.out.println("value = " + i);
		SimpleGen1 sg2 = new SimpleGen1("中软国际ETC");
		sg2.showType();
		Integer i1 = (Integer)sg2.getOb();
//		String str = (String) sg2.getOb();
		System.out.println("value = " + i1);
	}
}
