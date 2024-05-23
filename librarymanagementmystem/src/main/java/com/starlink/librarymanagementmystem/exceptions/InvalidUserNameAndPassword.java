package com.starlink.librarymanagementmystem.exceptions;

public class InvalidUserNameAndPassword extends RuntimeException {
	public InvalidUserNameAndPassword(String msg) {
		super(msg);
	}
}
