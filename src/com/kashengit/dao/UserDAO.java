package com.kashengit.dao;

import ch.qos.logback.core.db.DBHelper;
import com.kashengit.entity.User;
import com.kashengit.untity.ConnnectionDriver;
import com.kashengit.untity.DBhelper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Assert;


import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDAO {

    public  void save(User user){

        String sql="insert into table_name(code,name,tel) values(?,?,?)";

             DBhelper.update(sql,user.getCode(),user.getName(),user.getTel());


    }
    public void upDate(User user){

        String sql="update table_name set code=?,name=?,tel=? where id=?";
        DBhelper.update(sql,user.getCode(),user.getName(),user.getTel(),user.getId());



    }
    public User QueryByID(Integer id){

        String sql="select * from table_name where id=?";

        return  DBhelper.Query(sql,new BeanHandler<>(User.class),id);



    }
    public User QueryByname(String  name) {

        String sql = "select * from table_name where name=?";

        return   DBhelper.Query(sql, new BeanHandler<>(User.class), name);


    }

    public List<User> QueryAll(){

        String sql="select * from table_name ";

        return  DBhelper.Query(sql,new BeanListHandler<>(User.class));



    }
    public Map<String,Object>  QueryByIDMap(Integer id){

        String sql="select * from table_name where id=?";

        return  DBhelper.Query(sql,new MapHandler(),id);



    }
    public List<Map<String,Object>> QueryListMap(){

        String sql="select * from table_name ";

        return  DBhelper.Query(sql,new MapListHandler());





    }
    public Long QueryCount(){

        String sql="select count(*) from table_name";

        return  DBhelper.Query(sql, new ScalarHandler<Long>());


    }
    public List<String> QueryNameList(){

        String sql="select name from table_name ";

        return  DBhelper.Query(sql,new ColumnListHandler<String>());


    }

}
