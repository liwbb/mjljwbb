package com.kaishengit.dao;

import com.kaishengit.entity.Movie;
import com.kaishengit.untity.DBhelper;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class MovieDAO {
    public List<Movie>  findAll(){
        String sql="SELECT * from movie";
        return DBhelper.Query(sql,new BeanListHandler<>(Movie.class));
    }
    public List<Movie> findByPage(int start,int size){
        String sql="SELECT * from movie limit ?,?";
        return DBhelper.Query(sql,new BeanListHandler<>(Movie.class),start,size);
    }
    public Long findCount(){
        String sql="select count(*) from movie";
        return  DBhelper.Query(sql,new ScalarHandler<Long>());
    }


}
