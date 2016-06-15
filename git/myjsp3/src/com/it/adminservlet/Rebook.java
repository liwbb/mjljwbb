package com.it.adminservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.DAO.BoowBookservice;
import com.it.DAO.BorrowDAO;
import com.it.entity.Borrow;

/**
 * Servlet implementation class Rebook
 */
public class Rebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    BorrowDAO dao=new BorrowDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoowBookservice bbs=new BoowBookservice();
		String strId=request.getParameter("id");
		Borrow b=dao.queryOne(Integer.parseInt(strId));
		Object cardcode= b.getCid();
		Object bookcode= b.getBid();
		System.out.println(b+"~~~~~~~~~~~b");
		System.out.println(bookcode+"~~~~~~~~~~~b");
		System.out.println(cardcode+"~~~~~~~~~~~b");
		String msg=bbs.reBook(bookcode, cardcode);
		System.out.println(msg+"~~~~~~~~~msg");


//		request.setAttribute("list", b);
		response.sendRedirect("/myjsp3/home?msg="+msg);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
