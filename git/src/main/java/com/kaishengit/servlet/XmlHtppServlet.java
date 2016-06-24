package com.kaishengit.servlet;

import com.kaishengit.entity.User;
import com.kaishengit.service.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/ajex")
public class XmlHtppServlet extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(XmlHtppServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.addHeader("pragma","no-cache");
//        resp.addHeader("cache-control","no-cache");
//        resp.addHeader("expires","0");
        //服务器端处理缓存

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String token= UUID.randomUUID().toString();
        HttpSession session=req.getSession();
        session.setAttribute("token",token);
        req.setAttribute("token",token);




        resp.setContentType("text/html;charset=UTF-8");
        //下面的三个响应头告诉浏览器不要缓存响应结果
        resp.addHeader("pragma","no-cache");
        resp.addHeader("cache-control","no-cache");
        resp.addHeader("expires","0");


        String username=req.getParameter("username");
        username=new String(username.getBytes("ISO8859-1"),"UTF-8");
        logger.info("username:{}",username);
        if(username.indexOf("?")>0){
            username= username.substring(0,username.indexOf("?"));
        }

//
//
        UserDaoService userDaoService=new UserDaoService();
        User user=userDaoService.Query(username);
        logger.info("{}",user);


        PrintWriter pw=resp.getWriter();
        if(user!=null){
            pw.print("false");
        }else{
            pw.print("true");
        }
        pw.flush();
        pw.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String sessionToken= (String) session.getAttribute("token");
        String token=  req.getParameter("token");
        logger.info("sessionToken{}",sessionToken);
        logger.info("token{}sss",token);

        if(sessionToken!=null&&sessionToken.equals(token)){
            session.removeAttribute("token");
            req.setCharacterEncoding("UTF-8");
            String username=req.getParameter("username");
            String pwd=req.getParameter("pwd");
            User user=new User(username,pwd);
            logger.info("username-->{}---address--->{}",username,pwd);
            UserDaoService userDaoService=new UserDaoService();
            userDaoService.save(user);
            if(userDaoService.Query(username)!=null){
                logger.debug("{}添加成功",username);

            }else{
                logger.debug("{}添加失败",username);
            }


        }else{
            logger.warn("表單重複提交");

        }



    }
}
