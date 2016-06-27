package com.kaishengit.test;

import com.kaishengit.pojo.User;
import com.kaishengit.untity.MyBatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

import java.io.Reader;
import java.util.List;

public class UserDaoTest {
    private Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    private  SqlSession sqlSession = MyBatisUtil.getSqlSession();

    @Test
    public void TestfindByID() {


        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findByID", 2);
        Assert.assertNotNull(user);
        logger.debug("{}", user);
        sqlSession.close();

    }
    @Test
    public void TestSave() {


        User user=new User();
        user.setCode("30");
        user.setTitle("十万个为什么");
        user.setAuthor("谁知道");
        user.setPublishing("人民出版社");
        user.setTotal(20);
        user.setCount(20);
        sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);

        sqlSession.commit();

        sqlSession.close();

    }
    @Test
    public void TestDelete(){

        sqlSession.delete("com.kaishengit.mapper.UserMapper.delete",5);
        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public  void TestUpdate(){

        User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findByID", 6);
        logger.debug("{}",user);
        user.setCode("30");
        user.setTitle("水浒传");
        user.setAuthor("施耐庵");
        user.setPublishing("人民出版社");
        user.setTotal(20);
        user.setCount(20);
        logger.debug("{}",user);
        sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);


        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void TestFindAll(){

        List<User>  userList=sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
        for (User user:userList){
            logger.debug("{}",user);
        }
        Assert.assertEquals(4,userList.size());
        sqlSession.close();
    }



}
