package com.zml.test;

import org.apache.commons.codec.digest.DigestUtils;

public class DataBaseTest {
	public static void main(String[] args) {
		String salt = "123123rhjkhg2@#gfdg%&gd";
		String name = DigestUtils.md5Hex(salt);
		System.out.println(name);
	}
}
//602032eda566a2a1ddc4da3bf50c470a