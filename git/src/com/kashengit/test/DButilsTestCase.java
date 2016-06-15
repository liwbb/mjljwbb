package com.kashengit.test;

import com.kashengit.dao.UserDAO;
import com.kashengit.entity.User;
import com.kashengit.untity.ConnnectionDriver;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Assert;
import org.junit.Test;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class DButilsTestCase {
    UserDAO dao=new UserDAO();

    @Test
    public void TestSave(){
        User user=new User();
        user.setCode(120);
        user.setName("Tom");
        user.setTel(120);
        dao.save(user);


    }
    @Test
    public void TestUpdate(){
        User user=new User();
        user.setTel(110);
        user.setId(5);
        user.setCode(110);
        user.setName("Jim");
        dao.upDate(user);


    }
    @Test
    public void TestQueryByID(){
        System.out.println(dao.QueryByID(1));


    }
    @Test
    public void TestQuery(){
        System.out.println( dao.QueryAll());


    }
    @Test
    public void TestQueryByIDMap(){
        System.out.println( dao.QueryByIDMap(1));


    }
    @Test
    public void TestQueryListMap() {
        List<Map<String,Object>> userMapList =dao.QueryListMap();

        for (int i = 0; i < userMapList.size(); i++) {
            Map<String, Object> ma = userMapList.get(i);
            for (Map.Entry<String, Object> entey : ma.entrySet()) {
                System.out.println(entey.getKey() + "-->" + entey.getValue());


            }
            System.err.println("_-------------");


        }
    }
    @Test
    public void TestQueryCount(){

            Long coount= dao.QueryCount();


            Assert.assertEquals(new Long(7),coount);



    }
    @Test
    public void TestQueryNameList(){

            List<String> nameList= dao.QueryNameList();


            Assert.assertEquals(7,nameList.size());



    }

}
