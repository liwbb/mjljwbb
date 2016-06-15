package com.kashengit.test;

import com.kashengit.service.TestService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestTestService {
    Logger logger= LoggerFactory.getLogger(TestTestService.class);
    @Test
    public void TestService(){
        TestService testService=new TestService();
        testService.TestUser("jim","asdasdasdsadasdsadasd");
        logger.info("{}",testService.TestUser("jim","asdasdasdsadasdsadasd"));


    }

}
