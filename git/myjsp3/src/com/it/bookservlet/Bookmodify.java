package com.it.bookservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BookDAO;
import com.it.entity.Book;
import com.it.entity.Card;

/**
 * Servlet implementation class Bookmodify
 */
public class Bookmodify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    BookDAO dao=new BookDAO();
    
    public Bookmodify() {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book b=new Book();
	
		b.setId(Integer.parseInt(request.getParameter("id")));
		b.setCode(request.getParameter("code"));
		b.setTitle(request.getParameter("title"));;
		b.setAuthor(request.getParameter("author"));
		b.setPublishing(request.getParameter("publishing"));
		b.setTotal(Integer.parseInt(request.getParameter("total")));
		b.setCount(Integer.parseInt(request.getParameter("total")));
		System.out.println(b+"~~~b");
		System.out.println(dao.updateBook(b));
		
		if (dao.updateBook(b)) {
			request.getRequestDispatcher("/bookControls").forward(request, response);
//			response.sendRedirect("/bookControls");
		} else {
			
			request.setAttribute("list", b);
			String a = "404";
			// response.sendRedirect("/myjsp2/cardcontrol.jsp?id=404");
			request.getRequestDispatcher("/WEB-INF/book/update.jsp?id=404").forward(request, response);
		}
	}

}
