package com.kaishengit.service;

import com.kaishengit.dao.AdminDAO;
import com.kaishengit.entity.Admin;

import java.util.List;

public class PollingService {
    public List<Admin> findAll(){
        AdminDAO adminDAO=new AdminDAO();
        List<Admin> adminList= adminDAO.findAll();
        return adminList;
    }
    public List<Admin> findAllBymaxid(String maxid){
        AdminDAO adminDAO=new AdminDAO();
        List<Admin> adminList= adminDAO.findAllByMAXID(maxid);
        return adminList;
    }
}
