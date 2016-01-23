package com.test.smack;

import java.io.File;
import java.util.Collection;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.SmackConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.filter.MessageTypeFilter;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.packet.Presence.Type;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer;
import org.jivesoftware.smackx.muc.HostedRoom;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.RoomInfo;

public class XmppManager {
    
    private static final int packetReplyTimeout = 2000; // millis
    
    private String server;
    private int port;
    
    private ConnectionConfiguration config;
    private XMPPConnection connection;

    private ChatManager chatManager;
    private MessageListener messageListener;
    
    public XmppManager(String server, int port) {
        this.server = server;
        this.port = port;
    }
    
    
    public void sendGroupMessage(String groupName, String message) throws  XMPPException {
    	
//   	Collection<HostedRoom> rooms = MultiUserChat.getHostedRooms(
//                connection, "topics.neargroup");
//        for (HostedRoom room : rooms) {
//            System.out.println(room.getName());
//            
//        } 
    	MultiUserChat muc = new MultiUserChat(connection, groupName);
    	
    	muc.join("RaviDSDndra");
    	muc.sendMessage(message);
//MultiUserChat muc1 = new MultiUserChat(connection, groupName);
    	
    	//muc1.join("Ravindra");
    	//or muc.create(nick) if not exist
    	
//    	MultiUserChat muc1 = new MultiUserChat(connection, "28@topics.neargroup");
//    	muc1.join("61234");
    	//muc1.sendMessage(message);
    	 //muc.ad
//    	muc.sendMessage(message);
    	PacketFilter filter = new MessageTypeFilter(Message.Type.groupchat);
    	connection.addPacketListener(new PacketListener()
    	{
    	    @Override
    	    public void processPacket(Packet packet) 
    	    {
    	        Message message = (Message) packet;
    	        if (message.getBody() != null)
    	        {
    	        	//System.out.println(mes);
    	            String from = message.getFrom();
    	            String Body = message.getBody();
    	            //System.out.println();
    	            System.out.println(" from :" + from +" body : " + Body + " -" + message.getPacketID() + "="+message.nextID());
    	        }
    	    }
    	}, filter);
 //   	muc.addMessageListener(messageListener);
        //Roster roster = connection.getRoster();
////        System.out.println("---" + roster.getGroupCount() + "---- " + roster.getEntry("5@topics.neargroup"));
////        Collection<RosterGroup> rosterGroup = roster.getGroups();
////        System.out.println("size : " + rosterGroup.size());
////        for(RosterGroup rg : rosterGroup)
////        {
////        System.out.println(rg.getName());	
////       }
//        RosterGroup rosterGroup = roster.getGroup(groupName);
//        Collection<RosterEntry> entries = rosterGroup.getEntries();
//        for (RosterEntry entry : entries) {
//           String user = entry.getName();
//           System.out.println(String.format("Sending message " + message + " to user " + user));
//            Chat chat = chatManager.createChat(user, messageListener);
//            chat.sendMessage(message);
//        }
    }
    
    public void init() throws XMPPException {
        
        System.out.println(String.format("Initializing connection to server %1$s port %2$d", server, port));

        SmackConfiguration.setPacketReplyTimeout(packetReplyTimeout);
        
        config = new ConnectionConfiguration(server, port);
        config.setSASLAuthenticationEnabled(false);
        config.setSecurityMode(SecurityMode.disabled);
        config.setDebuggerEnabled(false);
        connection = new XMPPConnection(config);
        connection.connect();
        
        System.out.println("Connected: " + connection.isConnected());
        
       chatManager = connection.getChatManager();
        messageListener = new MyMessageListener();
        
    }
    
    public void performLogin(String username, String password) throws XMPPException {
        if (connection!=null && connection.isConnected()) {
            connection.login(username, password,"Ravindra");
        }
    }

    public void setStatus(boolean available, String status) {
        
        Presence.Type type = available? Type.available: Type.unavailable;
        Presence presence = new Presence(type);
        
        presence.setStatus(status);
        connection.sendPacket(presence);
        
    }
    
    public void destroy() {
        if (connection!=null && connection.isConnected()) {
            connection.disconnect();
        }
    }
    
    public void sendMessage(String message, String buddyJID) throws XMPPException {
        System.out.println(String.format("Sending mesage '%1$s' to user %2$s", message, buddyJID));
        Chat chat = chatManager.createChat(buddyJID, messageListener);
        chat.sendMessage(message);
    }
    
    public void createEntry(String user, String name) throws Exception {
        System.out.println(String.format("Creating entry for buddy '%1$s' with name %2$s", user, name));
        Roster roster = connection.getRoster();
        roster.createEntry(user, name, null);
    }
    
    class MyMessageListener implements MessageListener {

        @Override
        public void processMessage(Chat chat, Message message) {
            String from = message.getFrom();
            String body = message.getBody();
            System.out.println(String.format("Received message '%1$s' from %2$s", body, from));
        }
        
    }

//	public void fileTransfer() {
//		FileTransferManager manager = FileTransferManager.getInstanceFor(connection);
//		// Create the outgoing file transfer
//		OutgoingFileTransfer transfer = manager.createOutgoingFileTransfer("romeo@montague.net");
//		// Send the file
//		transfer.sendFile(new File("shakespeare_complete_works.txt"), "You won't believe this!");
//		
//	}
}