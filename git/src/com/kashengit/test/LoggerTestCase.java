package com.kashengit.test;



import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTestCase {
    @Test
    public void testLog(){
        String name="Alex";
        String bookName="《重构》";

        //Logger logger= Logger.getLogger(LoggerTestCase.class);
        Logger logger= LoggerFactory.getLogger(LoggerTestCase.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.warn("warn message");
        logger.info(name+"借阅了"+bookName);
        logger.error("error message");




    }
}
