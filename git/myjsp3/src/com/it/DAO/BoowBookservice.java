package com.it.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import com.it.instrument.Conf;

import java.sql.CallableStatement;




public class BoowBookservice {
	public String BoowBook(Object bookCode,Object cardCode){
		
		return callpro("{CALL pro_book_borrow(?,?,?)}",bookCode,cardCode);
		
	}
	public String reBook(Object bookCode,Object cardCode){
		
		return callpro("{CALL pro_book_re(?,?,?)}",bookCode,cardCode);
	}
	private String callpro(String proName,Object bookCode,Object cardCode){
		String msg="";
		try {
			Connection conn=DriverManager.getConnection(Conf.URL);
			CallableStatement scmt=conn.prepareCall(proName);
			scmt.setObject(1,bookCode );
			scmt.setObject(2, cardCode);
			
			scmt.executeQuery();
		
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
