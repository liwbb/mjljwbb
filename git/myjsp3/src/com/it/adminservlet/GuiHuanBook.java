package com.it.adminservlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BorrowDAO;
import com.it.entity.Book;
import com.it.entity.Borrow;

/**
 * Servlet implementation class GuiHuanBook
 */
public class GuiHuanBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuiHuanBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	BorrowDAO dao = new BorrowDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Borrow b=new Borrow();
		

	

		List<Borrow> Borrow=dao.queryAll();
		
		
		
		
		request.setAttribute("Borrow", Borrow);
		request.getRequestDispatcher("/WEB-INF/book/rebook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
