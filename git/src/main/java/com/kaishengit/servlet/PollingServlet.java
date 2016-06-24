package com.kaishengit.servlet;

import com.google.gson.Gson;
import com.kaishengit.entity.Admin;
import com.kaishengit.service.PollingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/pollingservlet")
public class PollingServlet extends HttpServlet {

    private Logger logger= LoggerFactory.getLogger(PollingServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PollingService pollingService = new PollingService();

        List<Admin> adminList = pollingService.findAll();
        resp.setContentType("appication/json;charset=UTF-8");

        req.setAttribute("adminList",adminList);

        int maxID=0;
        if(!adminList.isEmpty()){
            maxID=adminList.get(0).getId();

        }
        req.setAttribute("maxID",maxID);

        req.getRequestDispatcher("/WEB-INF/views/polling.jsp").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maxID=req.getParameter("maxID");

        List<Admin> adminList=new PollingService().findAllBymaxid(maxID);

        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(new Gson().toJson(adminList));
        out.flush();
        out.close();
    }
}
