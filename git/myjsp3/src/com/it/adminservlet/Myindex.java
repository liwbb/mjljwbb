package com.it.adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.AdminDAO;
import com.it.entity.Admin;

/**
 * Servlet implementation class Myindex
 */
public class Myindex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myindex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		String username=null;
		String password=null;
		if(cookies!=null){
			for (Cookie c : cookies) {
				if("name".equals(c.getName())){
					username=c.getValue();
				}else if("pwd".equals(c.getName())){
					password=c.getValue();
				}
			}
			
			
		}
		if(username!=null&&password!=null){
			AdminDAO dao=new AdminDAO();
			if(dao.queryOne(username,password)){
				request.getSession().setAttribute("name", username);
				response.sendRedirect("/myjsp3/home");
			}else{
				Cookie ck1=new Cookie("name", "");
				Cookie ck2=new Cookie("pwd", "");
				ck1.setPath("/");
				ck1.setMaxAge(0);
				ck1.setHttpOnly(true);
				ck2.setPath("/");
				ck2.setMaxAge(0);
				ck2.setHttpOnly(true);
				response.sendRedirect("/myjsp3/index");;
			}
		}
		
		request.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
