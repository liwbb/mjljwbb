package com.it.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BookDAO;

/**
 * Servlet implementation class Bookdel
 */
public class Bookdel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Bookdel() {
		super();
		// TODO Auto-generated constructor stub
	}

	BookDAO dao = new BookDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
//		dao.deleteBook(id);
		
		if (dao.deleteBook(id)) {
			request.getRequestDispatcher("/bookControls").forward(request, response);
//			response.sendRedirect("/bookControls");
		} else {
			
			// response.sendRedirect("/myjsp2/cardcontrol.jsp?id=404");
//			response.sendRedirect("/bookControls?id=404");
			request.getRequestDispatcher("/bookControls?id=404").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
