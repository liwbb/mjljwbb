package com.kaishengit.untity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory sessionFactory=buildSqlSessionFactory();

    private static SqlSessionFactory buildSqlSessionFactory() {
        try {
            Reader reder= Resources.getResourceAsReader("mybatis.xml");
            SqlSessionFactory sessionFactory= new SqlSessionFactoryBuilder().build(reder);
            return sessionFactory;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static SqlSession getSqlSession() {
        return getSessionFactory().openSession();
    }
}
