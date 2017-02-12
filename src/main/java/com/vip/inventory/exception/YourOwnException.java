package com.vip.inventory.exception;

@SuppressWarnings("serial")
public class YourOwnException extends Exception {

	private String message = null;

	public YourOwnException() {
		super();
	}

	public YourOwnException(String message) {
		super(message);
		this.message = message;
	}

	public YourOwnException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
