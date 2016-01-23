package com.test.smack;

public class generatePIN {

	public static void main(String[] args) {
		int randomPIN = (int)(Math.random()*9000)+1000;

        //Store integer in a string
		System.out.println(String.valueOf(randomPIN));
	}
}
