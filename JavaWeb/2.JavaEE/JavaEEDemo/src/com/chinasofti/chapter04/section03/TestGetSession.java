package com.chinasofti.chapter04.section03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestGetSession
 */
@WebServlet("/chapter04/TestGetSession")
public class TestGetSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestGetSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//客户端发送给服务器的字符编码进行设置  
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获得jsessionid，并输出其值
		Cookie [] cookies = request.getCookies();
		boolean flag = false;
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("JSESSIONGID")) {
					out.println("JSESSIONID="+c.getValue());
					flag = true;
					break;
				}
			}
		}
		//如果不存在jsessionid，则打印提示
		if(flag ==false) {
			out.println("当前请求中没有名字为JSESSIONID的cookie");
		}
		
		//获取当前session对象
		HttpSession session = request.getSession();
		//获取当前session对象的ID
		String id = session.getId();
		out.println("当前会话的ID是："+id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
