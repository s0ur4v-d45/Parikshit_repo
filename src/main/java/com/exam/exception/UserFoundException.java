package com.exam.exception;

public class UserFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserFoundException() {
		super("User with this Username is already there in DB !! try with another");
	}

	public UserFoundException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}
}
