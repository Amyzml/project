package com.zml.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zml.entity.Book;
import com.zml.it.AddException;
import com.zml.service.BookService;

public class EditServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		BookService bookService = new BookService();
		
			try {
				Book book = bookService.findByBookId(id);
				req.setAttribute("book",book);
				req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
			} catch (AddException e) {
				resp.sendError(404,e.getMessage());
			}
		
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String bookname = req.getParameter("bookname");
		String author = req.getParameter("author");
		String publish = req.getParameter("publish");
		String total = req.getParameter("total");
		String nowmuch = req.getParameter("nowmuch");
		
		BookService bookService = new BookService();
		
		Book book = new Book();
		book.setId(id);
		book.setBname(bookname);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setMuch(Integer.parseInt(total));
		book.setNowmuch(Integer.parseInt(nowmuch));
		
		bookService.editBook(book);
		resp.sendRedirect("/list");
		
		
		
	}
}
