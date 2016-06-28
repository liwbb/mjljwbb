package com.kaishengit.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kaishengit.Maspper.AdminMapper;
import com.kaishengit.pojo.Admin;
import com.kaishengit.untity.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class AdminTestCase {
    private Logger logger= LoggerFactory.getLogger(AdminTestCase.class);
    private SqlSession sqlSession= MyBatisUtil.getSqlSession();
    private AdminMapper adminMapper=sqlSession.getMapper(AdminMapper.class);
    @Test
    public void TestQueryByIdlIST(){
        List<Integer> list=Lists.newArrayList(55,71,78,72);
        List<Admin> adminList=adminMapper.queryMapId(list);
        sqlSession.close();
        for (Admin ad:adminList) {
            logger.debug("{}",ad);

        }

    }
    @Test
    public void TestQueryCase(){
        Map<String,Object> map=Maps.newHashMap();
//        map.put("name","金正恩");
        map.put("password","曹县");
       List<Admin> adminlist= adminMapper.queryMap(map);
        sqlSession.close();
        for (Admin admin:adminlist) {

            logger.debug("{}",admin);
        }

    }
    @Test
    public void TestQueryCases(){
        Map<String,Object> map=Maps.newHashMap();
//        map.put("name","金正恩");
        map.put("password","曹县");
        map.put("name","金正恩");

       List<Admin> adminlist= adminMapper.queryMapparam(map);
        sqlSession.close();
        for (Admin admin:adminlist) {

            logger.debug("{}",admin);
        }

    }
    @Test
    public void TestSaveCase(){
        Admin admin=new Admin("jim","787878");

        adminMapper.save(admin);
        sqlSession.commit();
        sqlSession.close();
        logger.debug("{}",admin);

    }
    @Test
    public void TestSaveAllCase(){
       List<Admin> adminList= Lists.newArrayList();
        adminList.add(new Admin("金正恩","曹县"));
        adminList.add(new Admin("金正日","曹县"));
        adminList.add(new Admin("金正一","曹县"));
        adminList.add(new Admin("金正六","曹县"));
        adminList.add(new Admin("金正二","曹县"));
        adminList.add(new Admin("金正仨","曹县"));
        adminList.add(new Admin("金正午","曹县"));
        adminMapper.saveAll(adminList);
        sqlSession.commit();
        sqlSession.close();
        for (Admin admin:adminList
             ) {

            logger.debug("{}",admin);
        }


    }
}
