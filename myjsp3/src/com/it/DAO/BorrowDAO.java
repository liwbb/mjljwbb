package com.it.DAO;

import java.util.List;

import com.it.entity.Book;
import com.it.entity.Borrow;
import com.it.instrument.BeanRowMapper;
import com.it.instrument.Conf;
import com.it.instrument.DBhelper;

public class BorrowDAO {
	DBhelper<Borrow> db=new DBhelper<Borrow>(Conf.URL);
	BeanRowMapper<Borrow> be=new BeanRowMapper<Borrow>(Borrow.class);
	
	public Boolean add(Borrow bor ){
		String sql="insert into borrow(bid,cid) values (?,?)";
		int str=db.update(sql, bor.getBid(),bor.getCid());
		return str==1;
		
	}
	public Borrow findOne(Borrow bor){
		String sql="select * from borrow where bid=? and cid=?";
		return db.queryOne(sql, be, bor.getBid(),bor.getCid());
	}
	public Borrow queryOne(int id){
		String sql="select * from borrow where id=?";
		return db.queryOne(sql, be,id);
	}
	public Borrow queryOne1(String  cid){
		String sql="select * from borrow where cid=?";
		return db.queryOne(sql, be,cid);
	}
	public Boolean remove(int id){
		String sql="delete from borrow where id=?";
		return db.update(sql, id)==1;
	}
	public List<Borrow> findOnes(String  str){
		String sql="select * from borrow where code bid '%"+str+"%' or cid='"+str+"'";
		return db.queryAll(sql, be);
	}
	public 	List<Borrow>  queryAll() {
		String sql="select * from borrow ";
		
		
		return  db.queryAll(sql, be);
		
	}
	
}
