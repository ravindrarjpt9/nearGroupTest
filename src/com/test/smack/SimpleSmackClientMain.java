package com.test.smack;

import java.io.File;

import org.jivesoftware.smack.XMPPException;

public class SimpleSmackClientMain {

	public static void main(String[] args) {
		 String username = "test";
	        String password = "test";
	        String buddyJID = "test1@neargroup/Spark";
	        SimpleSmackClient obj = new SimpleSmackClient();
	        try {
				obj.login(username, password);
				//obj.sendMessage("Hello", buddyJID);
				File file = new File("//Users//ravindrarjpt9//Pictures//IPhone backup//IMG_0036.JPG");
				System.out.println(file.exists());
				//obj.fileTransfer("//Users//ravindrarjpt9//Pictures//IPhone backup//IMG_0036.JPG", buddyJID);
				obj.fileReceiver(true, "/Users//ravindrarjpt9//Pictures//IPhone backup//0036.JPG");
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	}
}
