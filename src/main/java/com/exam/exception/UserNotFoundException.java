package com.exam.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("User with this Username not found in database !!");
	}

	public UserNotFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

}