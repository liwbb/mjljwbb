package com.kaishengit.service;

import com.kaishengit.dao.MovieDao;
import com.kaishengit.entity.Movie;
import com.kaishengit.untity.Page;

import java.util.List;

public class MovieService {
    private MovieDao movieDao=new MovieDao();
    public List<Movie> findAll(){
        List<Movie> movieList=movieDao.findll();
        return  movieList;
    }
    public Page<Movie> findByPage(int pageNo){

        int count=movieDao.findCount().intValue();
        Page<Movie> page=new Page<>(pageNo,10,count);
        List<Movie> movieList=movieDao.findByP(page.getStart(),10);
        page.setItems(movieList);
        return  page;



    }
}
