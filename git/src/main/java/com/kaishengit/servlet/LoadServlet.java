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

@WebServlet("/load")
public class LoadServlet extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(LoadServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String url=req.getParameter("url");
//
//
//
//       String xml= HttpUtil.getResquestText(url);
//        logger.debug("{}xml",xml);
//        resp.setContentType("text/xml;charset=UTF-8");
//        PrintWriter out=resp.getWriter();
//        out.print(xml);
//        out.flush();
//        out.close();

        String url = req.getParameter("url");//"http://blog.sina.com.cn/rss/1220218113.xml";
        logger.debug("url{}",url);

        String xml = HttpUtil.getResquestText(url);

        resp.setContentType("text/xml;charset=UTF-8");
        logger.debug("xml{}",xml);
        PrintWriter out = resp.getWriter();
        out.print(xml);
        out.flush();
        out.close();


    }
}
