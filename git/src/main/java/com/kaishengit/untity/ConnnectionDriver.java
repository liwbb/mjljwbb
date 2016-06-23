package com.kaishengit.untity;



import com.kaishengit.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnnectionDriver {
   private static BasicDataSource  dataSource=new BasicDataSource();
   static{
      dataSource.setDriverClassName(Conf.get("jdbc.driver"));
//      dataSource.setDriverClassName(pro.getProperty("jdbc.driver"));
      dataSource.setUrl(Conf.get("jdbc.url"));
      dataSource.setUsername(Conf.get("jdbc.username"));
      dataSource.setPassword(Conf.get("jdbc.password"));

      dataSource.setInitialSize(Integer.parseInt(Conf.get("jdbc.initsize","5")));
      dataSource.setMaxTotal(Integer.parseInt(Conf.get("jdbc.maxsize","20")));
      dataSource.setMaxWaitMillis(Integer.parseInt(Conf.get("jdbc.maxwait","5000")));
      dataSource.setMaxIdle(Integer.parseInt(Conf.get("jdbc.maxidle","10")));
      dataSource.setMinIdle(Integer.parseInt(Conf.get("jdbc.minidle","5")));



   }
   public static BasicDataSource getDataSource() {
      return dataSource;
   }
   public static Connection getConnection() throws DataAccessException {
      try {
         Connection connection=dataSource.getConnection();
         return  connection;
      } catch (SQLException e) {
        throw new DataAccessException("获取数据库异常",e);
      }
   }
   public static void closeConnection(Connection connection){
      try {
         connection.close();
      } catch (SQLException e) {
         throw new DataAccessException("关闭数据库异常",e);
      }
   }

}
