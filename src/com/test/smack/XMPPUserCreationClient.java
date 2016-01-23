package com.test.smack;

import javax.swing.JOptionPane;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class XMPPUserCreationClient {

	public static void main(String[] args) {
		
		String s = "{\"username\":\"1\",\"password\":\"1\",\"name\":\"Amit Goyal\",\"email\":\"anilgoyalp@gmail.com\"}";
		try {
	        Client client = Client.create();

	        //WebResource webResource = client.resource("http://localhost:8080/AlphaAppServer/alpha/registration");

	        //WebResource webResource = client.resource("http://119.9.107.53:8080/alphaserver/alpha/registration");

	        WebResource webResource = client.resource("http://119.9.107.53:9090/restapi/v1/users/");

	       
	        
	        String input = JOptionPane.showInputDialog("enter your string");

	        // POST method
	        ClientResponse response = webResource.accept("application/json")
	                .type("application/json").post(ClientResponse.class, input);

	        // check response status code
	        System.out.println(response.toString());
	        if (response.getStatus() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + response.getStatus());
	        }

	        // display response
	        String output = response.getEntity(String.class);
	        System.out.println("Output from Server .... ");
	        System.out.println(output + "\n");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	}
}
