package com.test.smack;

import javax.swing.JOptionPane;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import Decoder.BASE64Encoder;

public class HttpGetClient {

	public static void main(String a[])
	{ 
		// http://119.9.107.53:8080/alphaserver
		///alphaserver/alpha/getXmppDetails
		//String url = "http://localhost:8080/AlphaAppServer/alpha/registration";
		//String url = "http://localhost:8080/AlphaAppServer/alpha/verification";
		//String url = "http://localhost:8080/AlphaAppServer/alpha/getTopicListByGroupeCategory";
		//String url = "http://119.9.107.53:8080/alphaserver/alpha/getTopicListByGroupeCategory";
		//String url = "http://localhost:8080/AlphaAppServer/alpha/getTopicTosByGroupId/20";
		//String url = "http://localhost:8080/AlphaAppServer/alpha/getWriterTosByGroupId/9/26";
		String url = "http://localhost:8080/AlphaAppServer/alpha/deleteUser/7";
		//String url = "http://localhost:8080/AlphaAppServer/alpha/createWriter";
		//String url = "http://localhost:8080/AlphaAppServer/alpha/log";
		 //WebResource webResource = client.resource("http://localhost:8080/AlphaAppServer/alpha/createTopic");
		
		//String url = "http://localhost:8080/AlphaAppServer/alpha/getUserNameWithGenderWithRoleTosByGroupId/12";
		//String url = "http://localhost:8080/AlphaAppServer/alpha//joinTopicChat";
		//{"uId":1,"code":130479}
		/*
		 * 
		 * 
		 {
    "userId": 1,
    "topicId": 9,
    "groupIconCategory": "LOCALITY",
    "OwnerUser": false
}
		 */
		
		
		
		
		// {"id":1,"groupCategory":"Locality Group”}
		//String url = "http://localhost:8080/AlphaAppServer/alpha/getUserNameWithGenderTosByGroupId/3"; 
		//String url = "http://119.9.107.53:8080/alphaserver/alpha/registration";
		String name = "neargroupapps"; String password = "12#user1Pass"; 
		String authString = name + ":" + password; String authStringEnc = new BASE64Encoder().encode(authString.getBytes()); 
		System.out.println("Base64 encoded auth string: " + authStringEnc);
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
	ClientResponse resp = webResource.accept("application/json").type("application/json")
	.header("Authorization", "Basic " + authStringEnc) .get(ClientResponse.class); 
	
//		String s = JOptionPane.showInputDialog("Enter data : ");
//		ClientResponse resp = webResource
//				.type(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON)
//				.header("Authorization", "Basic " + authStringEnc).post(ClientResponse.class, s);
//	
		if(resp.getStatus() != 200){ 
			System.err.println("Unable to connect to the server");
		} 
		String output = resp.getEntity(String.class);
		System.out.println("response: "+output); }
	
}
