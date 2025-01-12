package com.bean;

public class User {
	 public String username,password,sqn;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		//this.sqn = sqn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getSqn() {
//		return sqn;
//	}
//
//	public void setSqn(String sqn) {
//		this.sqn = sqn;
//	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	

	
	

}
