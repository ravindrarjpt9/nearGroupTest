package com.test.smack;

public class Response {

	private boolean success;

	private Photo data;

	public Response(boolean success, Photo data) {
		this.success = success;
		this.data = data;
	}

	public Photo getData() {
		return data;
	}

	public boolean isSuccess() {
		return success;
	}
}
