package com.zml.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.zml.entity.Book;
import com.zml.service.BookService;
import com.zml.util.Page;

public class BookListServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BookService bookService = new BookService();
		
		String p = req.getParameter("p");
		
		int pageNow = 1;
		
		if (StringUtils.isNumeric(p)) {
			pageNow = Integer.parseInt(p);
		}
		
			List<Book> bookList = bookService.findAllBook(pageNow);
			
			Page<Book> page = bookService.findByPageNow(pageNow);
			
			//System.out.println(page.getPageTotal() +"-->"+ page.getPageNow());
			
			req.setAttribute("page",page);	
			
			req.setAttribute("bookList",bookList);
			req.getRequestDispatcher("WEB-INF/views/list.jsp").forward(req, resp);
	
		
		}

}
