package com.virtusa.project.users;


public class User {
	
	private int id;
	private String userName;
	private String userPassword;
	private long phoneNumber;
	
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected String getUserName() {
		return userName;
	}
	protected void setUserName(String userName) {
		this.userName = userName;
	}
	protected String getUserPassword() {
		return userPassword;
	}
	protected void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	protected long getPhoneNumber() {
		return phoneNumber;
	}
	protected void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
