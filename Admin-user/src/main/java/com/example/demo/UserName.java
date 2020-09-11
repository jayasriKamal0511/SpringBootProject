package com.example.demo;

import javax.persistence.Embeddable;

@Embeddable
public class UserName {
	
	private String firstUserName;
	
	private String lastUserName;
	
	public String getFirstUserName() {
		return firstUserName;
	}

	public void setFirstUserName(String firstUserName) {
		this.firstUserName = firstUserName;
	}

	public String getLastUserName() {
		return lastUserName;
	}

	public void setLastUserName(String lastUserName) {
		this.lastUserName = lastUserName;
	}



}
