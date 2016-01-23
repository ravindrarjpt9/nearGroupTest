package com.example.oops;

public class Student {

	private String name;
	private String address;
	private long mobile ;
	private static int id ;
	
	public  Student() {
		System.out.println("Defaut Const");
		
	}
	
	private  Student(String name) {
		System.out.println("Defaut Const");
		
	}
	
	
	
	public Student(String name, String address, long mobile) {
		System.out.println("Pemater const");
		this.name = name;
		this.address = address;
		this.mobile = mobile;
	}





	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public static void display()
	{
		System.out.println(" id :" + id);
		//System.out.println(" name : "+ name);
	}
	
	public void play()
	{
		System.out.println(" id :"+id);
		System.out.println(" name :"+name);
	}
	
}
