package com.revature.project0.data;


import java.util.ArrayList;
import java.util.List;

import com.revature.project0.userInfo.User;
import com.revature.project0.userInfo.UserType;


public class UserDoa {
	// DAO = Database Access Object
	// This is a class that is dedicated to accessing data from persistence.
	private static String filename = "users.dat";
	private static List<User> users;
	
	static {
		DataSerializer<User> ds = new DataSerializer<User>();
		users = ds.readObjectsFromFile(filename);
		
		// Helper for myself. If no users exist in the users.dat file (first startup) than I should create a few
		if(users == null) {
			users = new ArrayList<User>();
			users.add(new User(1234,  "Williamsn", "nedw@mail.com", 2345, 100l));
			users.add(new User(2345, "Kiml", "kiml@gmail.com", 5678, 3000l));
			users.add(new User(3456, "Smithj", "smithj@mail.com", 6789, 2000l));
			User u = new User(0011, "Kylie", "kylie.renner@revature.net", 1122, 1000l);
			u.setUserType(UserType.ADMIN);
			users.add(u);
			ds.writeObjectsToFile(users, filename);
		}
	}
	
	public User getUser(String username) {
		
		for(User user : users) {
			if(user.getUserName().equals(username)) {
				return user;
			}
			
		}
		
		return null;
	}
	

	
public User getBalance(Integer balance) {
	
	for(User user : users) {
		if(user.getBalance().equals(balance)) {
			return user;
		}
		
	}
	
	return null;
}

public User getAccountNumber(Integer accountNumber) {
	
	for(User user : users) {
		if(user.getAccountNumber().equals(accountNumber)) {
			return user;
		}
		
	}
	
	return null;
}

	public void updateUser(User user) {
		// due to us holding the entire list in memory, we will actually automatically update the user
		// in the list anytime we change the fields of the user object.
		// I'll leave this method as a placeholder for our Week 3 Database integration.
	}
	
	public void writeToFile() {
		new DataSerializer<User>().writeObjectsToFile(users, filename);
	}

}

