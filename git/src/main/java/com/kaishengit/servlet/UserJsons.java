package com.kaishengit.servlet;

import com.google.gson.Gson;
import com.kaishengit.entity.User;
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

@WebServlet("/user.jsons")
public class UserJsons extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Username> userList=new ArrayList<>();
        userList.add(new Username(1,"JIM","usa",89F));
        userList.add(new Username(2,"TOM","uK",89F));
        userList.add(new Username(3,"LILY","中国",83F));
        userList.add(new Username(4,"金正恩","韩国",84F));
        userList.add(new Username(5,"普金","俄罗斯",80F));
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();
        out.print(new Gson().toJson(userList));
        out.flush();
        out.close();
    }
}
