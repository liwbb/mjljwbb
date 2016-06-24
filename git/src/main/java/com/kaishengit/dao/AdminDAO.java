package com.kaishengit.dao;

import com.kaishengit.entity.Admin;
import com.kaishengit.untity.DBhelper;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AdminDAO {

    public List<Admin> findAll(){
        String sql="select * from admin order by id desc";
        return DBhelper.Query(sql,new BeanListHandler<>(Admin.class));
    }
    public List<Admin> findAllByMAXID(String maxid){
        String sql="select * from admin where id>? order by id desc";
        return DBhelper.Query(sql,new BeanListHandler<>(Admin.class),maxid);
    }
}
