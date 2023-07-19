package com.chinasofti.chapter10.section02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SevletMapping
 */
@WebServlet({ "/brain/*", "*.txt" })
public class SevletMapping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevletMapping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpServletMapping mapping = request.getHttpServletMapping();
//		
//		String mappingName  = mapping.getMappingMatch().name();
//		System.out.println("mappingName="+mappingName);
//		
//		String value = mapping.getMatchValue();
//		System.out.println("value="+value);
//		
//		String pattern = mapping.getPattern();
//		System.out.println("pattern="+pattern);
//		
//		String servletName = mapping.getServletName();
//		System.out.println("servletName="+servletName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
