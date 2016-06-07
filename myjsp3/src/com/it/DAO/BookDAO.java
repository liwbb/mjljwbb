package com.it.DAO;

import java.util.List;

import com.it.entity.Book;
import com.it.entity.Card;
import com.it.instrument.BeanRowMapper;
import com.it.instrument.Conf;
import com.it.instrument.DBhelper;
import com.sun.org.apache.regexp.internal.recompile;

public class BookDAO {
	DBhelper<Book> db = new DBhelper<Book>(Conf.URL);

	BeanRowMapper<Book> be = new BeanRowMapper<Book>(Book.class);
	public Book queryOne(int id) {
		String sql="select * from book where id=?";
		Book c=db.queryOne(sql, be, id);
		return  c;
		
	}
	public 	List<Book>  queryAll() {
		String sql="select * from book ";
		
		return  db.queryAll(sql, be);
		
	}
	public boolean addBook(Book b){
		String sql="insert into book (code,title,author,publishing,total,count) value(?,?,?,?,?,?)";
		int add= db.update(sql, b.getCode(),b.getTitle(),b.getAuthor(),
				b.getPublishing(),b.getTotal(),b.getCount());
		System.out.println(add);
		
		return add==1;
		
	}
	public boolean deleteBook(int  id){
		String sql="delete from book where id=?";
		int  del=db.update(sql, id);
		System.out.println(del+"~del");
		return del==1;
		
		
	}
	public boolean updateBook(Book b){
		String sql="update book set code=?,title=?,author=?,publishing=?,total=?,count=? where id=? ";
		int  del=db.update(sql,b.getCode(),b.getTitle(),b.getAuthor(),
				b.getPublishing(),b.getTotal(),b.getCount(),b.getId());
		return del==1;
		
	}
	public List<Book> queryOnes(String str){
		String sql="select * from book where code like '%"+str+"%' or title like '%"+str+"%' or author like '%"+str+"%' or publishing like '%"+str+"%'";
		return db.queryAll(sql, be);
	}

}
