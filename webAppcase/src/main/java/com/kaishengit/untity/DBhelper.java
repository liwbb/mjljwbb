package com.kaishengit.untity;

import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBhelper {
    Logger logger= LoggerFactory.getLogger(DBhelper.class);

   public static void update(String sql,Object... params){
       QueryRunner queryRunner=new QueryRunner(ConnnectionDriver.getDataSource());


       try {
           queryRunner.update(sql,params);
       } catch (SQLException e) {
           throw new DataAccessException("连接数据库异常",e);
       }
   }
    public static <T> T Query(String sql, ResultSetHandler<T> handler, Object... params){
        QueryRunner queryRunner=new QueryRunner(ConnnectionDriver.getDataSource());


        try {
            return queryRunner.query(sql,handler,params);
        } catch (SQLException e) {
            throw new DataAccessException("连接数据库异常",e);
        }
    }


}
