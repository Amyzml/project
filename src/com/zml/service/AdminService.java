package com.zml.service;

import org.apache.commons.codec.digest.DigestUtils;

import com.zml.dao.AdminDao;
import com.zml.entity.Admin;
import com.zml.it.AddException;

public class AdminService {
	public Admin login(String username,String password) throws AddException{
		
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.findByName(username);
		
		String salt = "rhjkhg2@#gfdg%&gd";
		password = DigestUtils.md5Hex(password + salt); 
		System.out.println(password);
		if (admin != null && password.equals(admin.getPassword())) {
			return admin;
		} else {
			throw new AddException("’ÀªßªÚ√‹¬Î¥ÌŒÛ");
		}
	}
}
