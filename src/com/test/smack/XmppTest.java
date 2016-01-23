package com.test.smack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XmppTest {
    
    public static void main(String[] args) throws Exception {
        
        String username = "neargroup_admin_1";
        String password = "neargroup_admin_1";
        
        XmppManager xmppManager = new XmppManager("119.9.107.53", 5222);
        
        xmppManager.init();
        xmppManager.performLogin(username, password);
        //xmppManager.setStatus(true, "Hello everyone");
        
        String buddyJID = "1@conference.neargroup";
        //String buddyName = "5";
        //xmppManager.createEntry(buddyJID, buddyName);
        
        //xmppManager.sendMessage("Hello Grou..", buddyJID);
        xmppManager.sendGroupMessage(buddyJID, "Welcome to group "+new Date().getTime());
        //xmppManager.fileTransfer();
        
        boolean isRunning = true;
        
        while (isRunning) {
            Thread.sleep(50);
        }
        
        xmppManager.destroy();
        
    }
    
//    public static long getDate()
//    {
//    	//String string_date = "12-December-2012";
//
//    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//    	Date date;
//		try {
//			date = (Date)formatter.parse("12-December-2012");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	long mills = date.getTime();
//    }
    

}