package org.example.week4.day27.proxy;

interface IMan1 {
	public void setName(String name);
	public String getName();
	public void qq();
	public void mm();
	public String sayHelp(String msg);
}
public class Man1 implements IMan1{
	String name;	
	public void setName(String name) {
		this.name=name;		
	}
	public String getName() {		
		return name;
	}	
	public void qq() {
		System.out.println("我在聊QQ"); 		
	}	
	public void mm() {
		System.out.println("我在撩M"); 			
	}
	@Override
	public String sayHelp(String msg) {
		System.out.println("求救方法,求救内容："+msg);
		return "马上解救你";
	}
}
