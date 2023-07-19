package com.chinasofti.chapter04.section02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/chapter04/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String value = request.getParameter("value");

		System.out.println("cookieName=" + name);
		System.out.println("cookieValue=" + value);

		if (name != null) {
			// 创建Cookie对象
			Cookie c = new Cookie(name, value);
			response.addCookie(c);
		} else {
			System.out.println("Cookie为空！！！");
		}
		Cookie[] cookies = request.getCookies();
		out.println("Cookie中的属性名和属性值的对应关系如下：");
		out.println("<br>");
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				out.println(cookie.getName() + "------->" + cookie.getValue());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
