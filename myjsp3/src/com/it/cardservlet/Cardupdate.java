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
 * Servlet implementation class Bookupdate
 */
public class Cardupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cardupdate() {
        super();
        // TODO Auto-generated constructor stub
    }
    CardDAO dao=new CardDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Card card=new Card();
		String strId=request.getParameter("id");
		int id=Integer.parseInt(strId);
	;
	
		
	Card list=dao.queryOne(id);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/card/cardupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
