package org.example.week4.day22.annotation;

public class TestMyAnnotation {

	public static void main(String[] args) {
//		返回LoginWebComponent以及LogoffWebComponent类的MyAnnotation5类型注解
		MyAnnotation5 loginA=LoginWebComponent.class.getAnnotation(MyAnnotation5.class);
		MyAnnotation5 logoffA=LogOffWebComponent.class.getAnnotation(MyAnnotation5.class);
		
//		返回LoginWebComponent以及LogoffWebComponent类的MyAnnotation5类型注解的两个属性值
		String loginurl=loginA.urlpattern();
		boolean loginload=loginA.onload();
		
		String logoffurl=logoffA.urlpattern();
		boolean logoffload=logoffA.onload();
		
//		调用LoginWebComponent以及LogoffWebComponent类的doPost方法，使用到了注解的属性值
		LoginWebComponent loginC=new LoginWebComponent();
		loginC.doPost(loginurl, loginload);
		
		LogOffWebComponent loginO=new LogOffWebComponent();
		loginO.doPost(logoffurl, logoffload);
	}

}
