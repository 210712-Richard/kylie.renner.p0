package com.revature.project0.services;




import com.revature.project0.userInfo.User;


import com.revature.project0.data.UserDoa;

public class UserServices {
private UserDoa ud = new UserDoa();
	
	public User login(String name) {
		User u = ud.getUser(name);
		return u;
	}
	
	public User balance(Integer amount) {
		User b = ud.getBalance(amount);
		return b;
		
	}
	
	public User accountNumber(Integer account) {
		User a = ud.getAccountNumber(account);
		return a;
	}
	
	public void register(String username, String email) {
		User u = new User();
		u.setUserName(username);
		u.setEmail(email);
		//ud.addUser(u);
		ud.writeToFile();
	}

}
