package com.it.DAO;

import com.it.entity.Admin;
import com.it.instrument.BeanRowMapper;
import com.it.instrument.Conf;
import com.it.instrument.DBhelper;

public class AdminDAO {
		DBhelper<Admin> db=new DBhelper<Admin>(Conf.URL);
		BeanRowMapper<Admin> be=new BeanRowMapper<Admin>(Admin.class);
		public boolean queryOne(String name ,String pwd) {
			String sql="select * from admin where name=? and password=?";
			Admin admin=db.queryOne(sql, be, name,pwd);
			return admin!=null;
			
		}

}
