package com.test.smack;


import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.iqregister.AccountManager;

public class PubSubManager {

	
        public static void main(String[] args){
                final ConnectionConfiguration config = new ConnectionConfiguration("140.112.170.32",Integer.parseInt("5222"));
                config.setReconnectionAllowed(true);
                config.setSendPresence(true);
                AccountManager accountManager;
                Connection connection = new XMPPConnection(config);
                try {
                        connection.connect();
PubSubManager manager = new PubSubManager(connection);//Here is error
                        accountManager = connection.getAccountManager();
                        connection.login("test1" , "test1");
                        System.out.println(connection.getUser());
                        connection.getChatManager().createChat("jabberuser@192.168.0.112/telnet",null). sendMessage("QQ QQ QQ");
                }catch (XMPPException e){
                        System.out.println("Connect error:" + e);
                }
        }}
