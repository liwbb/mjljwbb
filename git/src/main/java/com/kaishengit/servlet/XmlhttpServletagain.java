package com.kaishengit.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.lang.model.type.PrimitiveType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Ajex")
public class XmlhttpServletagain extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(XmlhttpServletagain.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //下面的三个响应头告诉浏览器不要缓存响应结果
        resp.addHeader("pragma","no-cache");
        resp.addHeader("cache-control","no-cache");
        resp.addHeader("expires","0");

        PrintWriter out = resp.getWriter();
        out.print("rose");
        out.flush();
        out.close();


//        String username=req.getParameter("username");
//        PrintWriter pw=resp.getWriter();
//        if(username.equals("Jim")){
//            pw.print("yes");
//
//        }else{
//            pw.print("no");
//        }
//        pw.flush();
//        pw.close();
    }
}
