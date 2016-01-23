package com.test.smack;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeStampUtil {

	public static void main(String[] args) {
		
		long millis = 
			    Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
		long GMT = 
			    Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
		System.out.println(GMT);

		System.out.println(millis);
	}
}
