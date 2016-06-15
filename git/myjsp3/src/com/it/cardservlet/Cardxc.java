package com.it.cardservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.CardDAO;

/**
 * Servlet implementation class Cardxc
 */
public class Cardxc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cardxc() {
        super();
        // TODO Auto-generated constructor stub
    }

	CardDAO dao=new CardDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wd="";
		if(request.getParameter("wd")!=null){
			wd=new String(request.getParameter("wd").getBytes("ISO-8859-1"),"utf-8");
			
		}
		request.setAttribute("list", dao.queryOnes(wd));
		request.getRequestDispatcher("/WEB-INF/card/cardlist.jsp").forward(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
