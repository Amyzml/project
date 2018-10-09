package com.zml.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zml.entity.Book;
import com.zml.util.Dbhelp;

public class BookDao {
	public Book findByIsbn(String isbn){
		String sql = "select * from t_book where isbn = ?";
		return Dbhelp.query(sql, new BeanHandler<>(Book.class), isbn);
	}
	
	public void addBook(Book book ){
		String sql = "insert into t_book (bname,author,publish,much,nowmuch,isbn) values (?,?,?,?,?,?)";
		Dbhelp.update(sql, book.getBname(),book.getAuthor(),book.getPublish(),book.getMuch(),book.getMuch(),book.getIsbn());
	}

	public List<Book> findAll() {
		String sql = "select * from t_book"; 
		return  Dbhelp.query(sql, new BeanListHandler<>(Book.class));
	}

	public void del(String id) {
		String sql = "delete from t_book where id = ?";
		Dbhelp.update(sql, id);
	}

	public Book findById(String id) {
		String sql = "select * from t_book where id = ?";
		return Dbhelp.query(sql, new BeanHandler<>(Book.class),id);
		
	}

	public void edit(Book book) {
		String sql = "update t_book set bname = ?,author = ?,publish = ?,much = ?,nowmuch = ? where id = ?";
		Dbhelp.update(sql, book.getBname(),book.getAuthor(),book.getPublish(),book.getMuch(),book.getNowmuch(),book.getId());
		
	}

	public List<Book> findByPageNow(int start, int pageSize) {
		String sql = "select * from t_book limit ?,?";
		//System.out.println(start + "--");
		//System.out.println(pageSize);
		return Dbhelp.query(sql, new BeanListHandler<>(Book.class),start,pageSize);
	}

	public int count() {
		String sql = "select count(*) from t_book";
		return Dbhelp.query(sql, new ScalarHandler<Long>()).intValue();
	}
	
}
