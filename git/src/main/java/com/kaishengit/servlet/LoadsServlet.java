package com.kaishengit.servlet;

import com.kaishengit.Util.HttpUtil;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loads")
public class LoadsServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(LoadsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getParameter("url");

        String xml=getCreat(url);
        PrintWriter pw=resp.getWriter();
        resp.setContentType("text/xml;charset=UTF-8");
        pw.flush();
        pw.close();
    }

    public static String getCreat(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            int httpCode = httpResponse.getStatusLine().getStatusCode();
            if (httpCode == 200) {
                InputStream inputStream = httpResponse.getEntity().getContent();
                String xml = IOUtils.toString(inputStream);

                return xml;
            } else {
                throw new RuntimeException("连接服务器异常" + httpCode);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                httpClient.close();
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


