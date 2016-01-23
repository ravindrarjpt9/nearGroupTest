package com.test.smack;

import java.util.Date;
import java.util.concurrent.CopyOnWriteArrayList;

public class GroupTreadTest {

	public static void main(String[] args) {
		System.out.println(" Start : " +new Date());
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("d");
		list.add("e");
		
		JoinGroupThread t = new JoinGroupThread(list);
		Thread t1 = new Thread(t);
		t1.start();
		System.out.println(" End : " +new Date());
		
	}
}
