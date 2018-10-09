package com.zml.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.zml.entity.Admin;
import com.zml.it.AddException;
import com.zml.service.AdminService;

public class loginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String callback = req.getParameter("callback");
		
		String boxLogin = req.getParameter("boxLogin");
		
		AdminService adminService = new AdminService();
		try {
			Admin admin = adminService.login(username, password);
			HttpSession session = req.getSession();
			session.setAttribute("admin", admin);
			
		if (StringUtils.isNotEmpty(boxLogin)) {
			
			Cookie cookie = new Cookie("username", username);
			cookie.setDomain("localhost");
			cookie.setPath("/");
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60*60*24*3);
			resp.addCookie(cookie);	
		}else {
			Cookie[] cookies = req.getCookies();
			for (Cookie cookie : cookies) {
				if ("username".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					cookie.setDomain("localhost");
					cookie.setPath("/");
					resp.addCookie(cookie);
				}
			}
		}	
			

			if (StringUtils.isNotEmpty(callback)) {
				resp.sendRedirect(callback);
			} else {
				resp.sendRedirect("/list");
			}

		} catch (AddException e) {
			req.setAttribute("error", e.getMessage());
			req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
		}
		
//		AdminDao adminDao = new AdminDao();
//		Admin admin = adminDao.findByName(username);
//		if (admin != null && password.equals(admin.getPassword())) {
//			
//			List<String> lists = new ArrayList<>();
//			lists.add("cuicui");
//			
//			req.setAttribute("username", username);
//			req.setAttribute("money", 1000);
//			req.setAttribute("list", lists);
//			RequestDispatcher rdc = req.getRequestDispatcher("home.jsp");
//			rdc.forward(req, resp);
//		} else {
//			resp.sendRedirect("/login.jsp?error=1001");
//		}
//		
		
		
		
		
		
//		
//		if ("tom".equals(username) && "123123".equals(password)) {
//			//÷ÿ∂®œÚ
////			resp.sendRedirect("/home.jsp?money=1000&name=" + username);
////		}else {
////			resp.sendRedirect("/login.jsp?error=1001");
//		
//			
//			List<String> lists = new ArrayList<>();			
//			lists.add("cuicui");
//			lists.add("zml");
//			
//			req.setAttribute("name", username);
//			req.setAttribute("money", 1000);
//			req.setAttribute("list", lists);
		
//			RequestDispatcher rdc = req.getRequestDispatcher("home.jsp");
//			rdc.forward(req, resp);
//		}else {
//			resp.sendRedirect("/login.jsp?error=1001");
//			
//		}
//		
//		
   	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		String username = "";
		if (cookies != null) {
			for (Cookie coo : cookies) {
				
				if ("username".equals(coo.getName())) {
					
				  username = coo.getValue();
				  break;
				}
			
			}
		}
		
		req.setAttribute("username", username);
		
		req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
	}
}
