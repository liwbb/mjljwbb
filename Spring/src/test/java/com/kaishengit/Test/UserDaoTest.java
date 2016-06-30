package com.kaishengit.Test;

import com.kaishengit.dao.UserDao;
import com.kaishengit.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserDaoTest {
    @Test
    public void TestUserDaoCase(){
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        UserDao userDao= (UserDao) context.getBean("userDao");
//        userDao.sayHi();
//        UserService userService= (UserService) context.getBean("UserService");
//        userService.sayHi();
//        UserDao userDao2= (UserDao) context.getBean("userDao");
//        userDao.sayHi();
//        System.out.println(userDao==userDao2);
    }
}
