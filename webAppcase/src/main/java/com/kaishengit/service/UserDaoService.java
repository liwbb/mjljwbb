package com.kaishengit.service;

import com.kaishengit.dao.UserDAO;
import com.kaishengit.entity.User;

public class UserDaoService {
    UserDAO userDAO=new UserDAO();
    public User Query(String name){
        User user=userDAO.findUser(name);
        return user;

    }
    public void save(User user){
        userDAO.save(user);



    }


}
