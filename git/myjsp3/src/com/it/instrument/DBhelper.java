package com.it.instrument;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBhelper<T> {
	private Connection conn;
	private PreparedStatement sta = null;
	private ResultSet rs = null;
	private String url;

	public DBhelper(String url) {
		this.url = url;

	}
	public List<T> queryAll(String sql,JieKou<T> be,Object... pamas){
		getStatement(sql);
		
		try {
			for (int i = 1; i < pamas.length+1; i++) {
				sta.setObject(i, pamas[i - 1]);
			}
			ResultSet rs=sta.executeQuery();
			System.out.println(rs.toString()+"~~~~~~~~~~~~~~~~~~");
			List<T> list=new ArrayList<>();
			while(rs.next()){
				
				 list.add(be.build(rs));
				 
				 
			}
			return list;
		} catch (Exception e) {
			System.out.println("查询失败");
			return null;
		}finally {
			closeConn();
		}
		
	}
	public T queryOne(String sql,JieKou<T> be,Object... pamas){
		getStatement(sql);
		
		try {
			for (int i = 1; i < pamas.length+1; i++) {
				sta.setObject(i, pamas[i - 1]);
			}
			ResultSet rs=sta.executeQuery();
			while(rs.next()){
				
				 return be.build(rs);
			}
			return null;
		} catch (Exception e) {
			System.out.println("查询失败");
			return null;
		}finally {
			closeConn();
		}
		
	}

	public int update(String sql, Object... pamas) {
		getStatement(sql);
		try {
			for (int i = 1; i < pamas.length + 1; i++) {

				sta.setObject(i, pamas[i - 1]);
			}
			return sta.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("更新失败");
			e.printStackTrace();
			return -1;
		}finally {
			closeConn();
		}
		

	}

	public void getStatement(String sql)  {
		System.out.println(url+"...url");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("类名错误");
			e.printStackTrace();
		}
		
		try {
			
			conn = DriverManager.getConnection(url);
			
			sta = conn.prepareStatement(sql);
		
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}

	}

	public void closeConn() {
		try {
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (sta != null) {
					sta.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e3) {
					// TODO: handle exception
				}
			}
		}

	}

}
