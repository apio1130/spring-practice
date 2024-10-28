package com.demo.sample.retry;

public class RetryException extends RuntimeException {
	public RetryException(String message) {
		super(message);
	}
}
