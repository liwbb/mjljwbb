package com.it.cardservlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BookDAO;
import com.it.DAO.CardDAO;

/**
 * Servlet implementation class Bookdel
 */
public class Carddel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */ 
	public Carddel() {
		super();
		// TODO Auto-generated constructor stub
	}

	CardDAO dao = new CardDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);

		
		if (dao.deleteCard(id)) {
			request.getRequestDispatcher("/cardcontrol").forward(request, response);

		} else {
			

			request.getRequestDispatcher("/cardcontrol?id=404").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
