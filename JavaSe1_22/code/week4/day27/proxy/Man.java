package org.example.week4.day27.proxy;

interface IMan {
	public void setName(String name);
	public String getName();
	public void qq();
	public void mm();
}
public class Man implements IMan{
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
}
