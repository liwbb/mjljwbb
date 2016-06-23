package com.kaishengit.servlet;

import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieDAOservice;
import com.kaishengit.untity.MovieCount;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieDAOservice movieDAOservice=new MovieDAOservice();


        String pagNo=req.getParameter("p");
        int p=1;
        if(StringUtils.isNumeric(pagNo)){
            p=Integer.parseInt(pagNo);

        }
        MovieCount<Movie> movieList=movieDAOservice.findByPage(p);



        req.setAttribute("movieList",movieList);


        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
    }
}
