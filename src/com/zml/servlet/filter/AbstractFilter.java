package com.zml.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public abstract class AbstractFilter implements Filter{
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init...");
		
	}

	@Override
	public abstract void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException;

	
	
	@Override
	public void destroy() {
		System.out.println("destroy...");
		
	}

}
