package com.test.smack;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadTesting {

	public static void main(String[] args) {
		
		System.out.println(" Start : " +new Date());
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		list.add("r");
		list.add("t");
		list.add("y");
		list.add("u");
		
		JoinGroupThread t = new JoinGroupThread(list);
		Thread t1 = new Thread(t);
		t1.start();
		System.out.println(" End : " +new Date());
		
	}
}
