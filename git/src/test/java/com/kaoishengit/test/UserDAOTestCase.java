package com.kaoishengit.test;

import com.kaishengit.dao.UserDAO;
import com.kaishengit.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAOTestCase {
    private Logger logger= LoggerFactory.getLogger(UserDAOTestCase.class);
    @Test
    public void TestCaseUserDAO(){
        UserDAO userDAO=new UserDAO();
        User user=userDAO.findUser("李经伟");
        logger.info("user:{}",user);
        Assert.assertNotNull(user);


    }
    @Test
    public  void TestUserdaoSave(){
        UserDAO userDAO=new UserDAO();
        User user=new User("jim","mjljwbb");
        userDAO.save(user);

    }
}
