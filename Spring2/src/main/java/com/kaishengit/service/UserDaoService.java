package com.kaishengit.service;

import com.kaishengit.Mapper.AdminDao;
import com.kaishengit.Mapper.UserDao;
import com.kaishengit.pojo.Admin;
import com.kaishengit.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional
public class UserDaoService {
    @Inject
    private UserDao userDao;
    @Inject
    private AdminDao adminDao;
    public void save(User user){
        userDao.save(user);
    }
    public User findById(int id){
       User user=userDao.findById(id);
        return user;
    }
    public User findByName(String name,String password,String ip){
        Admin admin=adminDao.findByName(name);
        if(admin!=null&&admin.getPassword().equals(password)){
            User user=new User();
            user.setUsername(name);
            user.setUserid(admin.getId());
            user.setUserip(ip);
            userDao.save(user);
            Finde finde=new Finde();
            finde.find();

            user=userDao.findByName(name);
            return user;




        }else{
            throw new RuntimeException("查询失败");
        }
    }
}
