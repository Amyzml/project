package com.zml.test;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.zml.entity.User;

public class Test {
	public static void main(String[] args) {
		
		User user1= new User();
		user1.setAge(20);
		user1.setFirstname("zml");
		user1.setLastname("cui");
		
		User user2 = new User();
		user2.setAge(20);
		user2.setFirstname("zml1");
		user2.setLastname("cuicui");
		
		User user3= new User();
		user3.setAge(20);
		user3.setFirstname("jh");
		user3.setLastname("zml");
		
		List<User> userList = Lists.newArrayList(user1,user2,user3);
		List<String> strList = Lists.newArrayList(Collections2.transform(userList, new Function<User, String>() {

			@Override
			public String apply(User user) {
				
				return user.getFirstname();
			}
		}));
		
		for(String str : strList){
			System.out.println(str);
		}

		List<User> uList = Lists.newArrayList(Collections2.filter(userList, new Predicate<User>() {

			@Override
			public boolean apply(User user) {
				
				return user.getFirstname().startsWith("zm");
			}
			
		})); 
		
		for(User str : uList){
			System.out.println(str);
		}
		
//		List<String> strList = Lists.newArrayList("a","b","c");
//		System.out.println(strList.size());
		
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//		long time = System.currentTimeMillis();
//		Date date = new Date(time);
//		System.out.println(df.format(date));
	}
}
