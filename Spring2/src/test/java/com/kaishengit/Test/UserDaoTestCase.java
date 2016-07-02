package com.kaishengit.Test;

import com.kaishengit.pojo.Admin;
import com.kaishengit.pojo.User;
import com.kaishengit.service.UserDaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class UserDaoTestCase {
    @Inject
    private UserDaoService userDaoService;
    @Test
    public void TestSaveCase(){
        User user=new User();
        user.setUsername("无菌");
        user.setUserid(9);
        user.setUserip("8.8.8.8");
        userDaoService.save(user);

    }
    @Test
    public void TestfindByName(){
        User user=userDaoService.findByName("金正一","曹县","6.6.6.6");
        System.out.println(user);

    }

}
