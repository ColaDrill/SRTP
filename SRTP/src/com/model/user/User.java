package com.model.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {
	
	@Id
	//@GeneratedValue(Strategy=GeneratedValue.IDENTITY)
	private String userNameString ;
	private String passWordString ;
	
	public String getUserNameString() {
		return userNameString;
	}
	public void setUserNameString(String userNameString) {
		this.userNameString = userNameString;
	}
	public String getPassWordString() {
		return passWordString;
	}
	public void setPassWordString(String passWordString) {
		this.passWordString = passWordString;
	}
	
	@Override
	public String toString() {
		return "User [userNameString=" + userNameString + ", passWordString="
				+ passWordString + "]";
	}
	
	public User() {
		//super();
	}
	public User(String userNameString, String passWordString) {
		//super();
		this.userNameString = userNameString;
		this.passWordString = passWordString;
	}
	
}
