package com.test.smack;

import java.util.Random;

public class Test1 {

	public static void main(String[] args) throws Exception{
		
		System.out.println(generatePin());
	}
	public static int generatePin() throws  Exception{
		Random generator = new Random();
		generator.setSeed(System.currentTimeMillis());
		  
		int num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) {
		num = generator.nextInt(99999) + 99999;
		if (num < 100000 || num > 999999) {
		throw new Exception("Unable to generate PIN at this time..");
		}
		}
		return num;
		}
}
