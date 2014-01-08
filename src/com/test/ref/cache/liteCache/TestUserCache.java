package com.test.ref.cache.liteCache;


public class TestUserCache {

public static void main(String[] args ){
		LiteCache<UserInfo> c = new LiteCache<UserInfo>();
		c.setKey("user_id");
		try {
			for(int i = 0 ;i<1000000000;i++){
				UserInfo u = new UserInfo();
				u.setUser_id("user_"+i);
				c.put(u);
				System.out.println(c.size());
			} 
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("over");
	}
}
