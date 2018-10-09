package com.zml.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	
	@Override
	public void contextInitialized(ServletContextEvent initEvent) {
		ServletContext context = initEvent.getServletContext();
		String name = context.getInitParameter("name");
		System.out.println("init name:" + name);
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent destroyEvent) {
		System.out.println("destroy...");
		
	}


}
