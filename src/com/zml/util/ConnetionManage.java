package com.zml.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.zml.it.DataAccessException;

public class ConnetionManage {
	
	private static  String DRIVER;
	private static  String URL;
	private static  String USERNAME;
	private static  String PASSWORD;
	private static BasicDataSource dataSource = new BasicDataSource();
	
	static{
		
		Properties prop = new Properties();
		try {
			prop.load(ConnetionManage.class.getClassLoader().getResourceAsStream("config.properties"));
			
		} catch (IOException e) {
			throw new DataAccessException("数据库连接异常");
		}
		
		DRIVER =  prop.getProperty("jdbc.driver");
		URL = prop.getProperty("jdbc.url");
		USERNAME = prop.getProperty("jdbc.username");
		PASSWORD = prop.getProperty("jdbc.password");
		
		dataSource.setDriverClassName(DRIVER);
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		
		dataSource.setInitialSize(5);
		dataSource.setMaxIdle(20);
		dataSource.setMinIdle(5);
		dataSource.setMaxWaitMillis(3000);
		
	}
	public static DataSource getDataSource(){
		return dataSource;
		
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
		    conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		    
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new DataAccessException("数据库连接异常");
		}
		
		return conn;
	}
}
