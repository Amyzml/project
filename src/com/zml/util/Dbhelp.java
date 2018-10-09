package com.zml.util;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.zml.it.DataAccessException;

public class Dbhelp {
	
	private static Connection getConnection(){
		return ConnetionManage.getConnection();
	}
	/**
	 * 增删改
	 * @param sql
	 * @param params
	 */
	public static void update(String sql,Object... params) throws DataAccessException{
		QueryRunner runner = new QueryRunner(ConnetionManage.getDataSource());
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			throw new DataAccessException("执行 " + sql + "异常");
		}
		
//		QueryRunner runner = new QueryRunner();
//		Connection conn = null;
//		try {
//			conn = getConnection();
//			runner.update(conn, sql, params);
//			
//		} catch (SQLException e) {
//			throw new DataAccessException("执行 " + sql + "异常");
//		}finally {
//			close(conn);
//		}
//		
	}
	/**
	 * 查
	 * @param sql
	 * @param rsh
	 * @param params
	 * @return
	 */
	public static <T>T query(String sql,ResultSetHandler<T> rsh,Object...params) throws DataAccessException{
		QueryRunner runner = new QueryRunner(ConnetionManage.getDataSource());
		
		try {
			T t =runner.query(sql, rsh, params);
			return t;
		} catch (SQLException e) {
			throw new DataAccessException("执行 " + sql + "异常");
		}
		
		
		
//		QueryRunner runner = new QueryRunner();
//		Connection conn = null;
//		T t = null;
//		try {
//			conn = getConnection();
//			t = runner.query(conn, sql, rsh, params);
//			
//		} catch (SQLException e) {
//			throw new DataAccessException("执行 " + sql + "异常");
//		}finally {
//			close(conn);
//		}
//		return t;
//	}
//
//	private static void close(Connection conn) {
//		try {
//			if (conn != null && !conn.isClosed()) {
//				conn.close();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
