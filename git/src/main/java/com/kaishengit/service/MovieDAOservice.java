package com.kaishengit.service;

import com.kaishengit.dao.MovieDAO;
import com.kaishengit.entity.Movie;
import com.kaishengit.untity.MovieCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MovieDAOservice {
    MovieDAO movieDAO=new MovieDAO();
    public List<Movie> findAll(){
        List<Movie> movieList=movieDAO.findAll();
        return  movieList;
    }
    private Logger logger= LoggerFactory.getLogger(MovieDAOservice.class);

    public MovieCount<Movie> findByPage(int p){
        int count=movieDAO.findCount().intValue();
        MovieCount<Movie> movieMovieCount=new MovieCount<>(count,10,p);
        List<Movie> movieList=movieDAO.findByPage(movieMovieCount.getStart(),10);

        movieMovieCount.setItems(movieList);
        return movieMovieCount;
    }
    public int findByCount(){
        int count=movieDAO.findCount().intValue();
        return  count;
    }
 }
