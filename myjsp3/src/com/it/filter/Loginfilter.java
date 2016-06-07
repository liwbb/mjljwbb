package com.it.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class Loginfilter
 */
public class Loginfilter implements Filter {

    /**
     * Default constructor. 
     */
    public Loginfilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	private String uris;
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String uri=req.getRequestURI();
		HttpSession session=(HttpSession)req.getSession();
		String[]  strs=uris.split(",");
		boolean flag=false;
		for (String str : strs) {
			if(uri.startsWith(str)){
				flag=true;
				break;
			}
		}
		if(flag){
			chain.doFilter(request, response);
		}else{
			Object name=session.getAttribute("name");
			
			if(name==null){
				res.sendRedirect("/myjsp3/index");
			}else{
				chain.doFilter(request, response);
			}
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		uris=fConfig.getInitParameter("uris");
	}

}
