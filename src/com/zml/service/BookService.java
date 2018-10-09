package com.zml.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.zml.dao.BookDao;
import com.zml.entity.Book;
import com.zml.it.AddException;
import com.zml.util.Page;

public class BookService {
	BookDao bookDao = new BookDao();
	public void addBook(String bname,String author,String publish,String much,String isbn) throws AddException{
		
		Book book = bookDao.findByIsbn(isbn);
		if (book == null) {
			
			book = new Book();
			book.setBname(bname);
			book.setAuthor(author);
			book.setPublish(publish);
			book.setMuch(Integer.parseInt(much));
			book.setIsbn(isbn);
			
			bookDao.addBook(book);
			
		}else {
			throw new AddException("isbn重复");
		}
		
	}

	public List<Book> findAllBook() {
		return bookDao.findAll();
		
	}
	public void delBook(String id){
		if (StringUtils.isNumeric(id)) {
			bookDao.del(id);
		} else {
			throw new AddException("参数异常");
		}
	}

	public void editBook(Book book) {
		bookDao.edit(book);
		
	}

	public Book findByBookId(String id) {
		Book book = null;
		if (StringUtils.isNumeric(id)) {
			book = bookDao.findById(id);
			if (book == null) {
				throw new AddException("参数不合理");
			}
		} else {
			throw new AddException("参数不合理");
		}
		return book;
	}

	public List<Book> findAllBook(int pageNow) {
		
		
		int pageSize = 3;
		int start = (pageNow - 1) * pageSize;
		
		return bookDao.findByPageNow(start,pageSize);
	}

	public Page<Book> findByPageNow(int pageNow) {
		
		int count = bookDao.count();
		Page<Book> page = new Page<>(pageNow,count);
		
		List<Book> list = bookDao.findByPageNow(page.getStart(),page.getPageSize());
		
		page.setItems(list);
		
		return page;
	}

}
