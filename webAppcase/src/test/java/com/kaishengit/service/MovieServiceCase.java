package com.kaishengit.service;

import com.kaishengit.dao.MovieDao;
import com.kaishengit.entity.Movie;
import com.kaishengit.untity.Page;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MovieServiceCase {




        private MovieDao movieDao=new MovieDao();
        private Logger logger= LoggerFactory.getLogger(MovieServiceCase.class);

        @Test
        public void TestMCase(){

            List<Movie> movieList=movieDao.findll();
            for (Movie m:movieList){
                logger.debug("资料{}",m);
            }
            Assert.assertNotNull(movieList);


        }
        @Test
        public void TestMBCase(){

            List<Movie> movieList=movieDao.findByP(0,10);
            for (Movie m:movieList){
                logger.debug("资料{}",m);
            }
            Assert.assertNotNull(movieList);


        }
    @Test
    public void TestfindbyPageCase(){

       MovieService movieService=new MovieService();
        Page<Movie> pages=movieService.findByPage(12);
        Assert.assertNotNull(pages);
        for (Movie m:pages.getItems()
             ) {
            logger.debug("{}",m);

        }
        logger.debug("{}",pages.getPageNo());


    }








}
