package com.kashengit.dao;

import com.kashengit.entity.Document;
import com.kashengit.entity.User;
import com.kashengit.untity.DBhelper;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class UpLoadDAO {

    public  void save(Document document){

        String sql="insert into input_upload(name,savename,extname,md5,size,displaysize)\n" +
                "VALUES(?,?,?,?,?,?);";

        DBhelper.update(sql,document.getName(),document.getSavename(),document.getExtname(),document.getMd5(),document.getSize(),document.getDisplaysize());


    }
    public List<Document> findAll(){

        String sql="SELECT * from input_upload ";
        return DBhelper.Query(sql,new BeanListHandler<>(Document.class));




    }

    public List<Document> QueryAll(){

        String sql="SELECT * from input_upload ORDER BY id ";

        return  DBhelper.Query(sql,new BeanListHandler<>(Document.class));



    }
    public Document   findByMd5(String md5){

        String sql="SELECT * from input_upload where md5=?";
        return DBhelper.Query(sql,new BeanHandler<>(Document.class),md5);




    }

}
