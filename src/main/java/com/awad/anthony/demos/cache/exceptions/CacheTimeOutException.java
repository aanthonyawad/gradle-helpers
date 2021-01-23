package com.awad.anthony.demos.cache.exceptions;

import java.util.concurrent.TimeoutException;

public class CacheTimeOutException extends TimeoutException {
	private String error;
	public CacheTimeOutException(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return error;
	}
}
