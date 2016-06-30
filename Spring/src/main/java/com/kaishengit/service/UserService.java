package com.kaishengit.service;

import com.kaishengit.dao.UserDao;

public class UserService {
    public UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void sayHi(){
        userDao.sayHi();
    }

}
