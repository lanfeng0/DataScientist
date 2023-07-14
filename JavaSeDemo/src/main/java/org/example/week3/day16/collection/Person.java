package org.example.week3.day16.collection;

public class Person {

	private String uname;
	private String pwd;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Person [uname=" + uname + ", pwd=" + pwd + "]";
	}

}
