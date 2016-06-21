package com.kaishengit.dao;

import com.kaishengit.entity.User;
import com.kaishengit.untity.DBhelper;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDAO {
    public User findUser(String name){
        String sql="SELECT * from admin where name=? ";

        User user= DBhelper.Query(sql,new BeanHandler<>(User.class),name);
        return user;


    }

    public  void save(User user){

        String sql="insert into admin(name,password) values(?,?)";

        DBhelper.update(sql,user.getName(),user.getPassword());


    }
}
