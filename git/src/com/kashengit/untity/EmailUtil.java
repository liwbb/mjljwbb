package com.kashengit.untity;

import com.kashengit.exception.DataAccessException;
import com.kashengit.service.TestService;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailUtil {
    private static Logger logger= LoggerFactory.getLogger(TestService.class);
    public static  void sendEmail(String toAdress,String Subject,String Msg){
        Email email=new SimpleEmail();
        email.setHostName(Conf.get("mail.hostname"));
        email.setAuthentication(Conf.get("mail.username"),Conf.get("mail.password"));
        email.setSmtpPort(Integer.parseInt(Conf.get("mail.port","25")));
        email.setCharset(Conf.get("mail.charset"));
        try {
            email.setFrom(Conf.get("mail.fromEmail"));
            email.setSubject(Subject);
            email.setMsg(Msg);
            email.addTo(toAdress);
            email.send();
            logger.info("给{}发送电子信息成功",toAdress);
        } catch (EmailException e1) {
            logger.info("给{}发送电子信息失败",toAdress);

            throw new DataAccessException("发送数据库失败",e1);
        }


    }





}
