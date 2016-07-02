package com.kaishengit.Test;

import com.kaishengit.pojo.Admin;
import com.kaishengit.service.AdminDaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class AdminDaoTest {
    @Inject
    private AdminDaoService adminDaoService;

    @Test
    public void saveTestCase(){
        Admin admin=new Admin();
        admin.setName("admin");
        admin.setPassword("admin");
        adminDaoService.save(admin);


    }
    @Test
    public void findOneTestCase(){
        Admin admin=adminDaoService.findOne(33);
        System.out.println(admin);


    }
    @Test
    public void findByNameTestCase(){
        Admin admin=adminDaoService.findByName("小乐");
        System.out.println(admin);


    }


}

