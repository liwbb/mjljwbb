package com.it.adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BorrowDAO;

/**
 * Servlet implementation class Borrowdel
 */
public class Borrowdel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrowdel() {
        super();
        // TODO Auto-generated constructor stub
    }

	BorrowDAO dao=new BorrowDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);

		
		if (dao.remove(id)) {
			request.getRequestDispatcher("/guiHuanBook?id="+id).forward(request, response);

		} else {
			

			request.getRequestDispatcher("/guiHuanBook?id=404").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
