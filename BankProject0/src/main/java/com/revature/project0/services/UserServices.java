package com.revature.project0.services;




import com.revature.project0.userInfo.User;
import com.revature.project0.data.UserDoa;

public class UserServices {
private UserDoa ud = new UserDoa();
	
	public User login(String name) {
		User u = ud.getUser(name);
		return u;
	}
	

}
