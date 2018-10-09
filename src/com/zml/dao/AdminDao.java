package com.zml.dao;

import org.apache.commons.dbutils.handlers.BeanHandler;
import com.zml.entity.Admin;
import com.zml.util.Dbhelp;

public class AdminDao {
	public Admin findByName(String name){
		String sql = "select * from t_admin where name = ?";
		return Dbhelp.query(sql, new BeanHandler<>(Admin.class), name);
		
	}
	

}
