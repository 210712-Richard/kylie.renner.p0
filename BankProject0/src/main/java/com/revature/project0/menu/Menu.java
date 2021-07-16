package com.revature.project0.menu;

import java.util.Scanner;


import com.revature.project0.userInfo.User;
import com.revature.project0.services.UserServices;
import com.revature.project0.until.SingletonScanner;

public class Menu {
	private UserServices us = new UserServices();
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
			switch(playerMenu()) {
			case 1:
				// daily bonus
//				if(us.hasCheckedIn(loggedUser)) {
//					System.out.println("Already checked in today, please try again tomorrow!");
//					break;
//				}
//				us.doCheckIn(loggedUser);
//				
//				System.out.println("Your new total is "+loggedUser.getCurrency()+" du-cats!");
//				break;
			case 2:
				// view balance
				System.out.println("You currently have "+loggedUser.getBalance()+" dollars.");
				break;
			case 3:
				// spend currency
				break;
			case 4:
				loggedUser = null;
				break user;
			default:
			}
		}
	}
	
	private int playerMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\t1. See current balance");
		System.out.println("\t2. Deposit money");
		System.out.println("\t3. Apply for loan");
		System.out.println("\t4. Withdraw money");
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
