package com.kaishengit.service;


import com.kaishengit.Mapper.AdminDao;
import com.kaishengit.pojo.Admin;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Transactional
public class AdminDaoService {
    @Inject
    private AdminDao adminDao;

    public void save(Admin admin){
        adminDao.save(admin);
    }
    public Admin findOne(int id){
        Admin admin=adminDao.findOne(id);
        return admin;
    }
    public Admin findByName(String name){
        Admin admin=adminDao.findByName(name);
        return admin;
    }
}
