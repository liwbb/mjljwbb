package com.kaoishengit.test;

import com.kaishengit.entity.Movie;
import com.kaishengit.untity.MovieCount;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MovieCountTestCase {
    @Test
    public void MovieTestCase(){
        Logger logger= LoggerFactory.getLogger(MovieCountTestCase.class);
        MovieCount<Movie> movieMovieCount=new MovieCount<>(868,10,0);
        logger.debug("start{}",movieMovieCount.getStart());

    }
}
