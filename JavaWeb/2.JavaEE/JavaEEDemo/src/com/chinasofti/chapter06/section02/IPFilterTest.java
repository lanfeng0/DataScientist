package com.chinasofti.chapter06.section02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class IPFilterTest
 */
@WebFilter(
		urlPatterns = { "/chapter06/IPFilterTest" }, 
		initParams = {
				@WebInitParam(name = "ip", value = "0:0:0:0:0:0:0:1")
		})
public class IPFilterTest implements Filter {

	private FilterConfig fileterConfig;
	private String ip;
    /**
     * Default constructor. 
     */
    public IPFilterTest() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String remoteIP = request.getRemoteAddr();
		System.out.println(remoteIP+" "+ip);
		if(remoteIP.equals(ip)) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<b>你的IP地址被禁用</b>");
			System.out.println("不让你访问了！！！");
		}else {
			PrintWriter out = response.getWriter();
			out.println(remoteIP+" "+ip);
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.fileterConfig = fConfig;
		this.ip = this.fileterConfig.getInitParameter("ip");
		System.out.println(ip);
	}
}
