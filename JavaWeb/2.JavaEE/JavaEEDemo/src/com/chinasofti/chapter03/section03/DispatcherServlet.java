package com.chinasofti.chapter03.section03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/chapter03/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置浏览器向服务器发送的字符编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset= utf-8");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("name");
		String pass = request.getParameter("password");
		
		//将一个字符串数组作为请求属性进行传递
		String [] addrs = {"BeiJing","ShangHai","GuangZhou"};
		request.setAttribute("city", addrs);
		
		if(userName.equals("Brain")&&pass.equals("111111")) {
			//request.getRequestDispatcher("success.jsp").forward(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("error.jsp");
		}
	}

}
