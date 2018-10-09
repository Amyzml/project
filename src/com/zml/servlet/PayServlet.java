package com.zml.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PayServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UUID uuid = UUID.randomUUID();
		
		req.setAttribute("token", uuid.toString());
		req.setAttribute("moeny", 100);
		
		HttpSession session = req.getSession();
		session.setAttribute("token", uuid.toString());
		
		req.getRequestDispatcher("/WEB-INF/views/pay/pay.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String money = req.getParameter("money");
		String formToken = req.getParameter("token");
		HttpSession session = req.getSession();
		String sessionToken = (String)session.getAttribute("token");
		
		if (sessionToken != null && sessionToken.equals(formToken)) {
			
			session.removeAttribute("token");
			req.setAttribute("money", money);
			req.getRequestDispatcher("/WEB-INF/views/pay/success.jsp").forward(req, resp);
		}else {
			req.getRequestDispatcher("/WEB-INF/views/pay/error.jsp").forward(req, resp);
		}
		
		
	}

}
