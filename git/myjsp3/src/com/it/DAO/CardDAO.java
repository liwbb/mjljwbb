package com.it.DAO;

import java.util.List;

import com.it.entity.Admin;
import com.it.entity.Card;
import com.it.instrument.BeanRowMapper;
import com.it.instrument.Conf;
import com.it.instrument.DBhelper;
import com.sun.org.apache.regexp.internal.recompile;

public class CardDAO {
	DBhelper<Card> db = new DBhelper<Card>(Conf.URL);

	BeanRowMapper<Card> be = new BeanRowMapper<Card>(Card.class);
	public Card queryOne(int  id) {
		String sql="select * from card where id=?";
		Card c=db.queryOne(sql, be, id);
		return  c;
		
	}
	public 	List<Card>  queryAll() {
		String sql="select * from card ";
		
		return  db.queryAll(sql, be);
		
	}
	public boolean addCard(Card c){
		String sql="insert into card (code,name,tel) value(?,?,?)";
		int add= db.update(sql, c.getCode(),c.getName(),c.getTel());
		return add==1;
		
	}
	public boolean deleteCard(int  id){
		String sql="delete from card where id=?";
		int  del=db.update(sql, id);
		return del==1;
		
		
	}
	public boolean updateCard(Card  c){
		String sql="update card set code=?,name=?,tel=? where id=?";
		int  del=db.update(sql, c.getCode(),c.getName(),c.getTel(),c.getId());
		return del==1;
		
	}
	public List<Card> queryOnes(String str){
		String sql="select * from card where code like '%"+str+"%' or name like '%"+str+"%' or tel like '%"+str+"%' ";
		return db.queryAll(sql, be);
	}
}
