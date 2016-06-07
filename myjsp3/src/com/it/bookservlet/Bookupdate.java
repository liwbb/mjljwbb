package com.it.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BookDAO;
import com.it.entity.Book;

/**
 * Servlet implementation class Bookupdate
 */
public class Bookupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookupdate() {
        super();
        // TODO Auto-generated constructor stub
    }
BookDAO dao=new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId=request.getParameter("id");
		int id=Integer.parseInt(strId);
		
		Book book=dao.queryOne(id);
		
		request.setAttribute("list", book);
		request.getRequestDispatcher("/WEB-INF/book/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
