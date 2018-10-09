package com.zml.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelCookieServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookie = req.getCookies();
		
		for (Cookie cookies : cookie) {
			
			if (cookies.getName().equals("kie1")) {
				cookies.setMaxAge(0);
				cookies.setDomain("localhost");
				cookies.setPath("/");
				resp.addCookie(cookies);
				System.out.println(cookies.getName() + "-->" + cookies.getValue());
			}
		}
		
	}
}
