package com.it.instrument;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class BeanRowMapper<T> implements JieKou<T> {
	private Class<T> type;
	public BeanRowMapper(Class<T> type){
		this.type=type;
	}

	@Override
	public T build(ResultSet rs) throws Exception {
		T obj=null;
		//
		obj=type.newInstance();
		ResultSetMetaData rsmd=rs.getMetaData();
		Method[] md=type.getMethods();
		for (int i = 1; i < rsmd.getColumnCount()+1; i++) {
			String colName=rsmd.getColumnLabel(i);
			colName=colName.substring(0, 1).toUpperCase()+colName.substring(1);
			colName="set"+colName;
			for (Method method : md) {
				if(method.getName().equals(colName)){
					method.invoke(obj, rs.getObject(i));
					break;
				}
			}
		}
		return obj;
	}

}
