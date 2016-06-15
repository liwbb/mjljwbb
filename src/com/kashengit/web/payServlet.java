package com.kashengit.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/payServlet")

public class payServlet extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(payServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String sessionToken= (String) session.getAttribute("token");
        String token=  request.getParameter("token");


        if(sessionToken!=null&&sessionToken.equals(token)){
            session.removeAttribute("token");
            String money=request.getParameter("money");
            logger.info("成功扣款{}元",money);
            request.getRequestDispatcher("/WEB-INF/views/paysuccess.jsp").forward(request,response);


        }else{
            logger.warn("表單重複提交");
            request.getRequestDispatcher("/WEB-INF/views/payerror.jsp").forward(request,response);
        }


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token=UUID.randomUUID().toString();
        HttpSession session=request.getSession();
        session.setAttribute("token",token);
        request.setAttribute("token",token);



        request.getRequestDispatcher("/WEB-INF/views/web.jsp").forward(request,response);
    }
}
