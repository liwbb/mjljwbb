package com.kaoishengit.test;

import com.kaishengit.entity.User;
import com.kaishengit.service.UserDaoService;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void ServiceTest(){
        UserDaoService userDaoService=new UserDaoService();
        User user=userDaoService.Query("李经伟");
        Assert.assertNotNull(user);
    }
}
