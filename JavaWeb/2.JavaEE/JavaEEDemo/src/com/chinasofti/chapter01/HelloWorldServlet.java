package com.chinasofti.chapter01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	//doGet()   接口 声明的对象   用来处理以get方式发送的请求
	//requset  请求 <------------------------->     response  响应
	public void doGet(HttpServletRequest requset,HttpServletResponse response) throws IOException {
		//设置响应的内容类型
		response.setContentType("text/html;charset= utf-8");
		//获得输出流
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>HelloWorld</title></head>");
	    out.println("<body bgcolor = 'red'>");
	    out.println("<center>HelloWorld世界你好！！！</cneter>");
	    out.println("</body></html>");
	}
	
	
	//doPost()  处理以post方式发送的请求
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		this.doGet(request, response);
	}
}
