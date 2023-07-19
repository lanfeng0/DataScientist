package com.chinasofti.chapter06.section01;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnLineCount
 *
 */
@WebListener
public class OnLineCount implements HttpSessionListener {

	//统计session的数量
	private int count = 0;
    /**
     * Default constructor. 
     */
    public OnLineCount() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    //监听session的创建
    public void sessionCreated(HttpSessionEvent se)  { 
        count++;
        se.getSession().setAttribute("Count", count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    //监听session的销毁
    public void sessionDestroyed(HttpSessionEvent se)  { 
        count--;
        se.getSession().setAttribute("Count", count);
    }
	
}
