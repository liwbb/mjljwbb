package com.it.adminservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BookDAO;
import com.it.entity.Book;

/**
 * Servlet implementation class BookControl
 */
public class BookControls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookControls() {
        super();
        // TODO Auto-generated constructor stub
    }

	BookDAO dao=new BookDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b=new Book();
		List<Book> list=dao.queryAll();
		System.out.println(list+"   book");
		request.setAttribute("list", list);
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
