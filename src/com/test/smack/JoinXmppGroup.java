package com.test.smack;

import javax.ws.rs.core.MediaType;

import org.omg.CORBA.portable.ApplicationException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JoinXmppGroup {

	public static final String XMPP_REST_API_CHAT_ROOMS_URL = "/chatrooms/";

	public static void main(String[] args) {
		// Setting the request path
				StringBuilder path = new StringBuilder();
				// Appending CHAT_ROOMS_URL
				path.append(XMPP_REST_API_CHAT_ROOMS_URL);
				// Appending roomName
				path.append("1");
				path.append("/");
				// Appending role
				path.append("members");
				path.append("/");
				// Appending userName
				path.append("test1");
				path.append("/");

				// Receiving clientResponse from post
				ClientResponse clientResponse = null;
				try {
					System.out.println(getPostResponse(path
							.toString()));
					clientResponse = getPostResponse(path
							.toString());
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
System.out.println("Resp :"+clientResponse.getResponseStatus());
				// Throwing ApplicationException if success response was not received
				if (clientResponse.getStatus() != 201) {
					System.out.println(clientResponse.getStatus());
				}
	}
	public static ClientResponse getPostResponse(String path)
			throws ApplicationException {
		// Instantiating the jersey client
		Client client = Client.create();

		// Creating a webResource with the Base URL
		WebResource webResource = client
				.resource("http://119.9.107.53:9090/plugins/restapi/v1/");

		// Fetching response after sending request on the specified path
		ClientResponse clientResponse = webResource.path(path)
				.type(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "G9IiL61zmcD757Dx")
				.post(ClientResponse.class);

		return clientResponse;
	}
}
