package com.zml.servlet.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zml.entity.Admin;

public class ValidateFilter extends AbstractFilter{

	@Override
	public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse)Response;
		HttpServletRequest req = (HttpServletRequest)Request;
		
		//获得请求的URL
		String uri = req.getRequestURI();
		
		if ("/".equals(uri) || "/login".equals(uri) || "/index.jsp".equals(uri) || uri.startsWith("/static")) {
			
			chain.doFilter(req, resp);
			
		}else {
			
			HttpSession session = req.getSession();
			Admin admin = (Admin)session.getAttribute("admin");
			
			if (admin != null) {
				chain.doFilter(req, resp);
				
			} else {
				uri = getRequestUri(uri,req);
				resp.sendRedirect("/login?callback=" + uri);
			}
		}
		
		
	}

	private String getRequestUri(String uri, HttpServletRequest req) {
		Map<String, String[]> maps = req.getParameterMap();
		Set<String> keySet = maps.keySet();
		
		Iterator<String> it = keySet.iterator();
		uri += "?";
		
		while (it.hasNext()) {
			String key = it.next();
			
			String[] value = maps.get(key);
			
			uri += key + "=" + value[0] + "&";		
			
		}
		
		uri = uri.substring(0,uri.length() - 1);
		
		System.out.println(uri);
		
		return uri;
	}

}
