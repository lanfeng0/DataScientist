package com.chinasofti.chapter02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestParamServlet
 */
@WebServlet("/chapter02/TestParamServlet")
public class TestParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置浏览器向服务器发送的字节编码
		request.setCharacterEncoding("UTF-8");
		//设置服务器返回给浏览器时的字符编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//获取前台表单页面提交的数据 一个数据
		String name = request.getParameter("userName");
		String pwd = request.getParameter("password");
		
		//获取前台表单页面提交的数据 多个数据
		String [] techs = request.getParameterValues("techs");
		
		String action = request.getParameter("action");
		
		out.println("用户名："+name+"<br>");
		out.println("密码："+pwd+"<br>");
		
		for(String t:techs) {
			out.println(t+"<br>");
		}
		
		out.println("隐藏参数action的值是："+action+"<br>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
