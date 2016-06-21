package com.kaoishengit.test;

import com.kaishengit.dao.MovieDAO;
import com.kaishengit.untity.MovieCount;
import org.junit.Assert;
import org.junit.Test;
import com.kaishengit.entity.Movie;
import com.kaishengit.service.MovieDAOservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class MovieDAOTestCase {
    private Logger logger= LoggerFactory.getLogger(MovieDAOTestCase.class);
    @Test
    public  void MovieCase(){
        MovieDAOservice movieDAOservice=new MovieDAOservice();
        List<Movie> movieList=movieDAOservice.findAll();

        for (Movie m:movieList
                ) {
            logger.debug("资料{}",m);

        }


    }
    @Test
    public  void MovieCaseBypage(){
        MovieDAOservice movieDAOservice=new MovieDAOservice();
        MovieCount<Movie> movieList=movieDAOservice.findByPage(11);

        logger.debug("start{}",movieList.getItems());


    }
    @Test
    public  void MovieCaseByCount(){
        MovieDAOservice movieDAOservice=new MovieDAOservice();
        int count=movieDAOservice.findByCount();


            logger.debug("资料数量{}",count);



    }

}
