package com.kashengit.web;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.Provider;

@WebServlet("/captcha.png")
public class CaptchaServlet extends HttpServlet {
    private Logger logger= LoggerFactory.getLogger(CaptchaServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConfigurableCaptchaService con=new ConfigurableCaptchaService();
        con.setColorFactory(new SingleColorFactory(new Color(25,60,170)));
        con.setFilterFactory(new CurvesRippleFilterFactory(con.getColorFactory()));


        OutputStream outputStream=response.getOutputStream();
        String captcha= EncoderHelper.getChallangeAndWriteImage(con,"png",outputStream);


        HttpSession session=request.getSession();
        session.setAttribute("captcha",captcha);

        logger.info(captcha+"captcha");
        outputStream.flush();
        outputStream.close();


    }
}
