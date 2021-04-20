package com.userservice.UserService.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Id
	 private long  userId;
	 private String userName;
	 private String password;
	 private String designation;
	 private long rmId;
	 
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", designation="
				+ designation + ", rmId=" + rmId + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(long userId, String userName, String password, String designation, long rmId) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.designation = designation;
		this.rmId = rmId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public long getRmId() {
		return rmId;
	}
	public void setRmId(long rmId) {
		this.rmId = rmId;
	}
	 

}
