package com.chrisb.authentication.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class LoginUser {

	
	@NotEmpty (message="Required!")
	@Email (message="Must be in email format")
	private String email;
	
	@NotEmpty (message="Required!")
	private String password;
	
	
	public LoginUser() {}


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
	
	
}
