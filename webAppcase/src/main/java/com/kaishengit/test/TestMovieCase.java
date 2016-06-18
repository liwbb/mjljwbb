package com.kaishengit.test;

import com.kaishengit.dao.MovieDao;
import com.kaishengit.entity.Movie;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TestMovieCase {

    private MovieDao movieDao=new MovieDao();
    private Logger logger= LoggerFactory.getLogger(TestMovieCase.class);

    @Test
    public void TestMCase(){

        List<Movie> movieList=movieDao.findll();
        for (Movie m:movieList){
            logger.debug("资料{}",m);
        }
        Assert.assertNotNull(movieList);


    }
}
