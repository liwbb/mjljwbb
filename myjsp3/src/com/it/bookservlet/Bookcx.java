package com.it.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BookDAO;

/**
 * Servlet implementation class Bookcx
 */
public class Bookcx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookcx() {
        super();
        // TODO Auto-generated constructor stub
    }

	BookDAO dao=new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wd="";
	if(request.getParameter("wd")!=null){
		wd=new String(request.getParameter("wd").getBytes("ISO-8859-1"),"utf-8");
		
	}
	request.setAttribute("list", dao.queryOnes(wd));
	request.getRequestDispatcher("/WEB-INF/book/booklist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
