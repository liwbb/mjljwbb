package com.kaishengit.servlet;

import com.google.gson.Gson;
import com.kaishengit.entity.Username;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user.json")
public class UserJson extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Username>  usernameList=new ArrayList<>();
        usernameList.add(new Username(1,"tom","USA",90.0F));
        usernameList.add(new Username(2,"Jim","Uk",89.0F));
        usernameList.add(new Username(1,"黎明","China",67.0F));
        usernameList.add(new Username(1,"李明基","Korea",90.0F));
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.print(new Gson().toJson(usernameList));
        out.flush();
        out.close();

    }
}


