package com.it.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BookDAO;
import com.it.entity.Book;

/**
 * Servlet implementation class Bookaddtj
 */
public class Bookaddtj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookaddtj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	BookDAO dao=new BookDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b=new Book();
		
		
	
		b.setCode(request.getParameter("code"));
		b.setTitle(request.getParameter("title"));;
		b.setAuthor(request.getParameter("author"));
		b.setPublishing(request.getParameter("publishing"));
		b.setTotal(Integer.parseInt(request.getParameter("total")));
		b.setCount(Integer.parseInt(request.getParameter("total")));
	
		
		if (dao.addBook(b)) {
			request.getRequestDispatcher("/bookControls").forward(request, response);
//			response.sendRedirect("/bookControls");
		} else {
			
			request.setAttribute("list", b);
			String a = "404";
			// response.sendRedirect("/myjsp2/cardcontrol.jsp?id=404");
			request.getRequestDispatcher("/WEB-INF/book/bookadds.jsp?id=404").forward(request, response);
		}
	}

}
