package com.it.cardservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BookDAO;
import com.it.DAO.CardDAO;
import com.it.entity.Book;
import com.it.entity.Card;

/**
 * Servlet implementation class Bookmodify
 */
public class Cardmodify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
    public Cardmodify() {
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

	CardDAO dao=new CardDAO();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Card c=new Card();
		
		c.setId(Integer.parseInt(request.getParameter("id")));
		c.setCode(request.getParameter("code"));
		c.setName(request.getParameter("name"));
		c.setTel(request.getParameter("tel"));
		System.out.println(c+"card~`c");
	
		System.out.println(c.getTel()+"~~tel");
		
		if (dao.updateCard(c)) {
			request.getRequestDispatcher("/cardcontrol").forward(request, response);
//			response.sendRedirect("/bookControls");
		} else {
			
			request.setAttribute("list", c);
			String a = "404";
			// response.sendRedirect("/myjsp2/cardcontrol.jsp?id=404");
			request.getRequestDispatcher("/WEB-INF/card/cardupdate.jsp?id=404").forward(request, response);
		}
	}

}
