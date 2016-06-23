package com.kaishengit.servlet;

import com.kaishengit.Util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/dict")
public class Dict extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(Dict.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word=req.getParameter("p");
        word= new String(word.getBytes("ISO8859-1"),"utf-8");
        logger.debug("word{}",word);
        String url="http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q="+word;
        String dict= HttpUtil.getResquestText(url);
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        logger.debug("dict{}",dict);
        pw.print(dict);
        pw.flush();
        pw.close();

    }
}
