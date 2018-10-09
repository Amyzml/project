package com.zml.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zml.it.AddException;
import com.zml.service.BookService;

public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		String bookname = req.getParameter("bookname");
		String author = req.getParameter("author");
		String publish = req.getParameter("publish");
		String total = req.getParameter("total");
		String isbn = req.getParameter("isbn");

		BookService bookService = new BookService();
		
		
		
			try {
				bookService.addBook(bookname, author, publish, total, isbn);
				
				resp.sendRedirect("/list");
				
			} catch (AddException ex) {
				// resp.sendRedirect("add.jsp?error" + ex.getMessage());

				req.setAttribute("bookname", bookname);
				req.setAttribute("author", author);
				req.setAttribute("publish", publish);
				req.setAttribute("total", total);			
				req.setAttribute("isbn", isbn);
				req.setAttribute("error", ex.getMessage());

				req.getRequestDispatcher("WEB-INF/views/add.jsp").forward(req, resp);
			}
		

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			req.getRequestDispatcher("WEB-INF/views/add.jsp").forward(req, resp);
	}
}
