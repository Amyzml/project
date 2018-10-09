package com.zml.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookieServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookie("kie1","1001");
		cookie.setDomain("localhost");
		cookie.setPath("/");
		cookie.setMaxAge(60*60*24*7);
		resp.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("kie2", "1002");
		cookie2.setDomain("localhost");
		cookie2.setPath("/");
		cookie2.setMaxAge(60*60*24);
		resp.addCookie(cookie2);

	}
}
