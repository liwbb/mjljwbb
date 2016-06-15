package com.it.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Mylisten
 *
 */
public class Mylisten implements ServletContextListener, HttpSessionListener {

    /**
     * Default constructor. 
     */
    public Mylisten() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	
    	ServletContext application = arg0.getSession().getServletContext();
    	
		Object count = application.getAttribute("count");
		if (count == null) {
			application.setAttribute("count", 1);
			
		} else {
			application.setAttribute("count", (Integer.parseInt(count.toString()) + 1));
		}
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	ServletContext application = arg0.getSession().getServletContext();
		Object count = application.getAttribute("count");
		application.setAttribute("count", (Integer.parseInt(count.toString()) - 1));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
