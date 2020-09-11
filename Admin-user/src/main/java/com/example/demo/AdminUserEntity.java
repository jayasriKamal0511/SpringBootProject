package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AdminUser")
public class AdminUserEntity {
	
	@Id
	private int userId;
	
	private UserName userName;
	
	private String AccountStatus;
	
	private String AccessDetails;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserName getUserName() {
		return userName;
	}

	public void setUserName(UserName userName) {
		this.userName = userName;
	}

	public String getAccountStatus() {
		return AccountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}

	public String getAccessDetails() {
		return AccessDetails;
	}

	public void setAccessDetails(String accessDetails) {
		AccessDetails = accessDetails;
	}


}
