package com.kaishengit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletxml")
public class ServletXml  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/xml;chartset=UTF-8");
        resp.setContentType("text/xml;charset=UTF-8");
        PrintWriter pw=resp.getWriter();
        pw.print("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        pw.print("<users>");
        pw.print("<user id=\"5197-5742-5657\">\n" +
                "\t\t<names>Java编程思想</names>\n" +
                "\t\t<price>91.6</price>\n" +
                "\t\t<authors>\n" +
                "\t\t\t<author>\n" +
                "\t\t\t\t<name>汤姆斯</name>\n" +
                "\t\t\t\t<adress>usa</adress>\n" +
                "\t\t\t</author>\n" +
                "\t\t\t<author>\n" +
                "\t\t\t\t<name>杰西姆</name>\n" +
                "\t\t\t\t<adress>uk</adress>\n" +
                "\t\t\t</author>\n" +
                "\t\t\n" +
                "\t\t</authors>\n" +
                "\t\t\n" +
                "\t\t\t\t\n" +
                "\t\t<gift/>\n" +
                "\t</user>");
        pw.print("<user id=\"8795-4574-7519\">\n" +
                "\t\t<names>深入浅出AJAX</names>\n" +
                "\t\t<price>88.0</price>\n" +
                "\t\t<authors>\n" +
                "\t\t\t<author>\n" +
                "\t\t\t\t<name>刘美美</name>\n" +
                "\t\t\t\t<adress>China</adress>\n" +
                "\t\t\t</author>\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\t</authors>\n" +
                "\t\t<gift>\n" +
                "\t\t\t\t<theme>主题T-Shirt</theme>\n" +
                "\t\t\t\t<gname>水杯</gname>\n" +
                "\t\t\t\t\n" +
                "\t\t</gift>\n" +
                "\t\t\n" +
                "\t</user>");
        pw.print("<user id=\"8795-4574-7519\">\n" +
                "\t\t<names>滨城思想</names>\n" +
                "\t\t<price>88.0</price>\n" +
                "\t\t<authors>\n" +
                "\t\t\t<author>\n" +
                "\t\t\t\t<name>刘加</name>\n" +
                "\t\t\t\t<adress>China</adress>\n" +
                "\t\t\t</author>\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\t</authors>\n" +
                "\t\t<gift>\n" +
                "\t\t\t\t<theme>主题T-Shirt</theme>\n" +
                "\t\t\t\t<gname>水杯</gname>\n" +
                "\t\t\t\t\n" +
                "\t\t</gift>\n" +
                "\t\t\n" +
                "\t</user>");
        pw.print("<user id=\"8795-4574-7519\">\n" +
                "\t\t<names>AJaX</names>\n" +
                "\t\t<price>88.0</price>\n" +
                "\t\t<authors>\n" +
                "\t\t\t<author>\n" +
                "\t\t\t\t<name>tom</name>\n" +
                "\t\t\t\t<adress>usa</adress>\n" +
                "\t\t\t</author>\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\t</authors>\n" +
                "\t\t<gift>\n" +
                "\t\t\t\t<theme>主题T-Shirt</theme>\n" +
                "\t\t\t\t<gname>水杯</gname>\n" +
                "\t\t\t\t\n" +
                "\t\t</gift>\n" +
                "\t\t\n" +
                "\t</user>");
        pw.print("<user id=\"8795-4574-7519\">\n" +
                "\t\t<names>JavaScript</names>\n" +
                "\t\t<price>88.0</price>\n" +
                "\t\t<authors>\n" +
                "\t\t\t<author>\n" +
                "\t\t\t\t<name>jim</name>\n" +
                "\t\t\t\t<adress>China</adress>\n" +
                "\t\t\t</author>\n" +
                "\t\t\t\n" +
                "\t\t\t\n" +
                "\t\t\n" +
                "\t\t</authors>\n" +
                "\t\t<gift>\n" +
                "\t\t\t\t<theme>主题T-Shirt</theme>\n" +
                "\t\t\t\t<gname>水杯</gname>\n" +
                "\t\t\t\t\n" +
                "\t\t</gift>\n" +
                "\t\t\n" +
                "\t</user>");

        pw.print("</users>");
        pw.flush();
        pw.close();

    }
}


