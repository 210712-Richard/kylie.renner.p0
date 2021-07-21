package com.revature.project0.menu;

import java.util.Scanner;

import com.revature.project0.data.UserDoa;
import com.revature.project0.services.UserServices;
import com.revature.project0.until.SingletonScanner;
import com.revature.project0.userInfo.User;

public class Menu {
	private UserServices us = new UserServices();
	private UserDoa ud = new UserDoa();
	private User loggedUser = null;
	private Scanner scan = SingletonScanner.getScanner().getScan();
	
	public void start() {
		
		mainLoop: while(true) {
			switch(startMenu()) {
			case 1:
				// login
				System.out.println("Please enter your username: ");
				String username = scan.nextLine();
				// Call the user service to find the user we want.
				User u = us.login(username);
				if(u == null) {
					System.out.println("Please try again.");
				} else {
					loggedUser = u;
					System.out.println("Welcome back: "+u.getUserName());
					// call our next method (either the Player menu or the Admin menu, depending on user)
					
					switch(loggedUser.getUserType()) {
					case USER:
						user();
						break;
					case ADMIN:
						master();
						break;
					}
				}
				break;
			case 2:
				// register
				break;
			case 3:
				// quit
				System.out.println("Goodbye!");
				break mainLoop;
			default:
				// invalid selection
				System.out.println("Not a valid selection, please try again.");
			}
		}
	}
	
	private int startMenu() {
		//log
		System.out.println("Welcome to PNC BANK!");
		System.out.println("What would you like to do?");
		System.out.println("\t1. Login");
		System.out.println("\t2. Register");
		System.out.println("\t3. Quit");
		return select();
	}
	
	private void user() {
		user: while(true) {
			switch(userMenu()) {
			case 1:
				// view balance
				System.out.println("You currently have "+loggedUser.getBalance()+" dollars.");
				break;
			case 2:
				Double deposit = scan.nextDouble();
				//loggedUser.setBalance(loggedUser.getBalance() + deposit);
				Double balance = loggedUser.getBalance()+ deposit;
				loggedUser.setBalance(balance);
				System.out.println("You currently have "+loggedUser.getBalance()+" dollars.");
				ud.writeToFile();
				break;
			case 3:
				// withdraw currency
				Double withdraw = scan.nextDouble();
				Double withdrawBalance = loggedUser.getBalance()- withdraw;
				loggedUser.setBalance(withdrawBalance);
				System.out.println("You currently have "+loggedUser.getBalance()+" dollars.");
				ud.writeToFile();
				break;
			case 4:
				
				break;
			case 5:
				loggedUser = null;
				break user;
			default:
			}
		}
	}
	
	private int userMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\t1. See current balance");
		System.out.println("\t2. Deposit money");
		System.out.println("\t3. Withdraw money");
		System.out.println("\t4. Apply for loan");
		System.out.println("\t5. Logout");
		return select();
	}
	private void master() {
		master: while(true) {
			
		}
	}
	
	
	private int select() {
		int selection;
		try {
			selection = Integer.parseInt(scan.nextLine());
		} catch(Exception e) {
			selection = -1;
		}
		//log
		return selection;
	}

}
