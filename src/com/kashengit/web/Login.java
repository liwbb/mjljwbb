package com.kashengit.web;

import com.kashengit.entity.User;
import com.kashengit.service.TestService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(payServlet.class);

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.判断验证码是否正确
        //1.1 获取表单中的值
        String captcha = req.getParameter("captcha");
        //1.2 获取session中的值
        String sessionCaptcha = (String) req.getSession().getAttribute("captcha");

        if(captcha != null && captcha.equalsIgnoreCase(sessionCaptcha)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            TestService testService=new TestService();
            User user=new User();
            DateTime dateTime=DateTime.now();
            user=testService.TestUser(username,password);
            if(user!=null){
                logger.debug("{}在{}登录成功",username,dateTime);


            }else{
                resp.sendRedirect("/login?code=1002");
            }




        } else {
            //验证输入错误
            logger.warn("验证码错误");
            resp.sendRedirect("/login?code=1001");
        }




    }
}
