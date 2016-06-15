package com.kashengit.service;

import com.kashengit.dao.UserDAO;
import com.kashengit.entity.User;
import com.kashengit.exception.DataAccessException;
import com.kashengit.untity.EmailUtil;
import org.apache.commons.codec.digest.Crypt;
import org.apache.commons.codec.digest.Md5Crypt;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * 用户登录
 * @username 用户名
 * @password 密码
 * @return 如果登陆成功就返回user 失败返回null
 */

public class TestService {
    private Logger logger= LoggerFactory.getLogger(TestService.class);
    private UserDAO userDAO=new UserDAO();
    final User user=new User();
    public User TestUser(String name,String password){
       User user= userDAO.QueryByname(name);


        if(user!=null&&user.getTel().equals(password)){
            logger.debug("{}登陆成功",name);
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    EmailUtil.sendEmail("1764187968@qq.com","我在办公室等你","带上资料过来");

                }
            });
            logger.debug("{}在{}登录成功",name, DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
            return  user;
        }
        return null;

    }
}
