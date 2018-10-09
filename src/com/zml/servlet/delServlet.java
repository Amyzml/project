package com.zml.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zml.it.AddException;
import com.zml.service.BookService;

public class delServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		BookService bookService = new BookService();
		
			try {
				bookService.delBook(id);
				resp.sendRedirect("/list");
			} catch (AddException e) {
				resp.sendError(404, e.getMessage());
			}
			
		
		
		
		
	}
}
