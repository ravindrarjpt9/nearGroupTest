package com.test.smack;


public class Photo {

	private int id;
	private String data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//@JsonSerialize(using= ByteArraySerializer.class)
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
