package edu.sjsu.cmpe282.domain;

import java.sql.Timestamp;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String passwd;
	private Timestamp lastLogin;

	public User() {
		super();
	}


	public User(int userId, String firstName, String lastName, String email,
			String passwd, Timestamp lastLogin) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwd = passwd;
		this.lastLogin = lastLogin;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		// new com.sun.jersey.spi.container.servlet.ServletContainer();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

}
