package com.it.adminservlet;


import java.lang.reflect.Method;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class BRMsuper<T>  extends HttpServlet   {

	private static final long serialVersionUID = 1L;
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	private Class<T> type;
	public BRMsuper(Class<T> type ,HttpServletRequest request,HttpServletResponse response) {
		this.type = type;
		this.request = request;
		this.response = response;
	}
	public T build() throws Exception {
		T obj = null;
		try {
			obj = type.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// method �洢 T �ķ���
		Method[] method = type.getMethods(); 
		// ���洢 ����  ֵ�洢 ������get�����ķ�������  ������String �� Integer
		HashMap<String,String> map = new HashMap<>();
		request.setCharacterEncoding("utf-8");
		for (Method me : method) {
			if(me.getName().contains("get")){
				String name = me.getName().substring(3);
				name = name.substring(0, 1).toLowerCase() + name.substring(1);
				Class<?> type = me.getReturnType();
				map.put(name, type.getSimpleName());
			}
		} 
		for(Entry entry : map.entrySet()) {
			String name = entry.getKey().toString();
			String typ = entry.getValue().toString();
			String nameu = name.substring(0,1).toUpperCase() + name.substring(1);
			nameu ="set" + nameu;
			String str = request.getParameter(name);
//			System.out.println("str  :" + str); 
//			System.out.println("name: " + name);
//			System.out.println("nameu: " + nameu);
//			System.out.println(name + "  :  " + nameu + "  :  " + typ);
			for (Method me : method) {
				if(me.getName().equals(nameu)){ 
				//	System.out.println("��������" + me.getName());
					if(str == null){
						break;
					}
					if(typ.equals("String")){
						me.invoke(obj, str);
					} else {
						//System.out.println( "adfsdf" + str);
						me.invoke(obj, Integer.parseInt(str));
					}
					System.out.println("obj   :" + obj );
					break;
				}
			} 
		}
		return obj;
	}
}
