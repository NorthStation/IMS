package com.lms.zx.exception.product;

public class ProductIdExistedException extends Exception {

	public ProductIdExistedException() {
		super();
	}

	public ProductIdExistedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductIdExistedException(String message) {
		super(message);
	}

	public ProductIdExistedException(Throwable cause) {
		super(cause);
	}

}
