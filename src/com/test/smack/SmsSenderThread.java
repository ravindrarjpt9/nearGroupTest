package com.test.smack;

import javax.ws.rs.core.MultivaluedMap;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class SmsSenderThread implements Runnable{

	String url = "http://smsbox.in/SecureApi.aspx?usr=prashant&key=8547025F-652D-4B5F-9ED6-C5408E707CDB&smstype=TextSMS&to=9717393010&msg=hii%20how%20r%20u%20ravssssindra%20?%20thnaks&rout=Transactional&from=nGroup";
	@Override
//	public void run() {
//		
//		Client restClient = Client.create();
//		WebResource webResource = restClient.resource(url);
//		ClientResponse resp = webResource.get(ClientResponse.class); 
//		if(resp.getStatus() != 200){ 
//			System.err.println("Unable to connect to the server");
//		} 
//		String output = resp.getEntity(String.class);
//		System.out.println(output.substring(output.indexOf("-")+1)); 
//		
//	}
	
	
	public void run() {
		String url = "";
		String tId = "";
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
	    params.add("usr","prashant");
	    params.add("key","8547025F-652D-4B5F-9ED6-C5408E707CDB");
	    params.add("smstype","TextSMS");
	    params.add("to","9717393010"+"".trim());
	    params.add("msg","Let's make a Better india"+System.getProperty("line.separator")+System.getProperty("line.separator")
	    		+ "Chat with ur Neighbours to:"+System.getProperty("line.separator")+System.getProperty("line.separator")
	    		+ "- Carpool"+System.getProperty("line.separator")
	    		+ "- Exercise and play sports"+System.getProperty("line.separator")
	    		+ "- Seek local-advice"+System.getProperty("line.separator")
	    		+ ""+System.getProperty("line.separator")+System.getProperty("line.separator")
	    		+ "Download NearGroup App"+System.getProperty("line.separator")
	    		+ "http://get.neargroup.in");
	    params.add("rout","Transactional");
	    params.add("from","nGroup");
	    
		try{
		System.out.println("*** Going to send Welcome to ["+"9717393010"+"] ");
		 url = "http://smsbox.in/SecureApi.aspx";
				 //"?usr="+Constants.SMS_USER+"&key="+Constants.SMS_KEY+"&smstype="+Constants.SMS_TYPE+"&to="+toMobileNumber+"&msg="+Constants.SMS_MSG.replace("#code#", code)+"&rout="+Constants.SMS_ROUT+"&from="+Constants.SMS_FROM;
		
		 Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.queryParams(params).get(ClientResponse.class); 
		if(resp.getStatus() != 200){ 
			System.out.println(" ****** error while sending Welcome to ["+"9717393010"+"]  **** Unable to connect to the server");
		} 
		String output = resp.getEntity(String.class);
		tId = output.substring(output.indexOf("-")+1);
		System.out.println(" Welcome to ["+"9717393010"+"] TransactionId ["+tId+"]" );
		}catch (Exception e) {
			//System.out.println("Error while send OTP to user ["+url+"]",e);
			Client restClient = Client.create();
			WebResource webResource = restClient.resource(url);
			ClientResponse resp = webResource.queryParams(params).get(ClientResponse.class); 
			if(resp.getStatus() != 200){ 
				System.out.println(" ****** error while Welcome OTP to ["+"9717393010"+"] **** Unable to connect to the server");
			} 
			String output = resp.getEntity(String.class);
			tId = output.substring(output.indexOf("-")+1);
			System.out.println(" Welcome to ["+"9717393010"+"]  TransactionId ["+tId+"]" );
		}
		
		System.out.println("**** Fine put Delivery report of TransactionId ["+tId+"]" );
		try{
			
			params.clear();
			 params.add("usr","prashant");
			 params.add("pwd","123456");
			 params.add("type","delivery");
			 params.add("transactionId",tId);
	
			 url = "http://smsbox.in/SecureApi.aspx";
				 //"?usr="+Constants.SMS_USER_NAME+"&pwd="+Constants.SMS_PASSWORD+"&type=delivery"+"&transactionId="+tId;

		 Client restClient = Client.create();
			WebResource webResource = restClient.resource(url);
			ClientResponse resp = webResource.queryParams(params).get(ClientResponse.class); 
			if(resp.getStatus() != 200){ 
				System.out.println(" ****** error while getting Delivery to ["+"9717393010"+"]  TransactionId ["+tId+"]**** Unable to connect to the server");
			} 
			String output = resp.getEntity(String.class);
			System.out.println("TransactionId ["+tId+"] Delivery report ["+output+"]");
		}catch(Exception e)
		{
			System.out.println("Error while getting Delivery report of TransactionId ["+tId+"]"+e.getLocalizedMessage()+"");
		}

	}
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new SmsSenderThread());
		t1.start();
	}
}
