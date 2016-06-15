package com.kashengit.test;

import com.kashengit.entity.User;
import com.kashengit.service.TestService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestServiceCase {
    @Test
    public void testServiceSmtp(){
        Logger logger= LoggerFactory.getLogger(TestServiceCase.class);
        TestService testService=new TestService();
        User user=testService.TestUser("jim","sdsdsd");
        logger.info("{}",user);

    }
    @Test
    public void testEamil(){
        Logger logger= LoggerFactory.getLogger(TestServiceCase.class);
        TestService testService=new TestService();
        User user=testService.TestUser("jim","82cc921c6a5c6707e1d6e6862ba3201a");
        logger.info("{}",user);

    }
}
