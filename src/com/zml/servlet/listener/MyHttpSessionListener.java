package com.zml.servlet.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent creat) {
		System.out.println("sessionCreate..");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent destory) {
		System.out.println("sessionDestroy...");
		
	}

}
