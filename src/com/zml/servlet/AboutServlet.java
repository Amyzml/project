package com.zml.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AboutServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("dopost...");	
	}
	public AboutServlet(){
		System.out.println("aboutServlet...");
	}
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		
//		Enumeration<String> names = config.getInitParameterNames(); 
//		while (names.hasMoreElements()) {
//			String name = names.nextElement();
//			String password = config.getInitParameter(name);
//			System.out.println(name + "--" + password);
//		}
		
//		String name = config.getInitParameter("name");
//		System.out.println("name:" + name);
//	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("name", "tom");
		
		HttpSession session = req.getSession();
		session.setAttribute("password", "123123");
		
		getServletContext().setAttribute("name", "jack");;
		
		req.getRequestDispatcher("/about.jsp").forward(req, resp);
	}
	
}
