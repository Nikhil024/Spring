package com.thbs.Beans;

import java.util.Date;

public class UsersBean {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String userType;
	private String emailVerified;
	private String adminAccepted;
	private String subscribed;
	private String LastLogin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(String emailVerified) {
		this.emailVerified = emailVerified;
	}
	public String getAdminAccepted() {
		return adminAccepted;
	}
	public void setAdminAccepted(String adminAccepted) {
		this.adminAccepted = adminAccepted;
	}
	public String getSubscribed() {
		return subscribed;
	}
	public void setSubscribed(String subscribed) {
		this.subscribed = subscribed;
	}
	public String getLastLogin() {
		return LastLogin;
	}
	public void setLastLogin(String lastLogin) {
		LastLogin = lastLogin;
	}
}
