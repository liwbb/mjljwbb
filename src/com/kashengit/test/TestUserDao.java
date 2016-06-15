package com.kashengit.test;

import com.kashengit.dao.UserDAO;
import com.kashengit.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUserDao {
    Logger logger= LoggerFactory.getLogger(TestUserDao.class);
    @Test
    public void TestDao(){
        UserDAO userDAO=new UserDAO();
        userDAO.QueryByname("jim");
        Assert.assertNotNull(userDAO.QueryByname("jim"));
        logger.info("{}"+userDAO.QueryByname("jim"));
    }
    @Test
    public void TestMd5(){

        String md5= DigestUtils.md5Hex("sdsdsd");
        Logger logger=LoggerFactory.getLogger(TestUserDao.class);
        logger.info("{}",md5);
    }
    @Test
    public void Update(){

        User user=new User();
        user.setId(2);
        UserDAO userDAO=new UserDAO();
        userDAO.upDate(user);
        Logger logger=LoggerFactory.getLogger(TestUserDao.class);
        logger.info("{}",user);
    }
    @Test
    public void Save(){

        User user=new User(18,"jim","asdasd");

        UserDAO userDAO=new UserDAO();
        userDAO.save(user);
        Logger logger=LoggerFactory.getLogger(TestUserDao.class);
        logger.info("{}",user);
    }
    @Test
    public void QuertById(){



        UserDAO userDAO=new UserDAO();
        User user=userDAO.QueryByID(2);
        Logger logger=LoggerFactory.getLogger(TestUserDao.class);
        logger.info("{}",user);
    }

}
