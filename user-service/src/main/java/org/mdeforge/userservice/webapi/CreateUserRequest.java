package org.mdeforge.userservice.webapi;

import java.util.ArrayList;
import java.util.List;

public class CreateUserRequest {

	private String firstname;
	private String lastname;
	private String email;
	private String username;

	public CreateUserRequest() {}

	public CreateUserRequest(String firstname, String lastname, String email, String username) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
