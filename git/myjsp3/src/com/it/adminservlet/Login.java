package com.it.adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.AdminDAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	AdminDAO dao=new AdminDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		System.out.println(name);
		String pwd=request.getParameter("pwd");
		String rememberme=request.getParameter("rememberme");
		if(dao.queryOne(name, pwd)){
			if ("yes".equals(rememberme)) {
				Cookie ck1 = new Cookie("name", name);
				Cookie ck2 = new Cookie("pwd", pwd);
				ck1.setPath("/");
				ck1.setMaxAge(60 * 60 * 24 * 7);
				ck1.setHttpOnly(true);
				ck2.setPath("/");
				ck2.setMaxAge(60 * 60 * 24 * 7);
				ck2.setHttpOnly(true);
				response.addCookie(ck1);
				response.addCookie(ck2);
			}
			request.getSession().setAttribute("name", name);
			response.sendRedirect("/myjsp3/home");
//			request.getRequestDispatcher("/home").forward(request, response);;
		}else{
			request.getRequestDispatcher("/index?id=404").forward(request, response);;
		}
		doGet(request, response);
	}

}
