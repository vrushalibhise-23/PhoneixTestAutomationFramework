package com.dataprovider.beans;

import com.poiji.annotation.ExcelCellName;

public class UserBean {
   @ExcelCellName("username")
	private String username;
   
   @ExcelCellName("password")
	private String password;
	
	public UserBean() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserPOJO [username=" + username + ", password=" + password + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
