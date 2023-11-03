package com.javacodegeeks.examples.jaxws;

import javax.xml.ws.Endpoint;

public class PersonPublisher {

	public static void main(String[] args) {
		Endpoint ep = Endpoint.create(new PersonServiceImpl());
		ep.publish("http://127.0.0.1:10000/personServer");
	}

}
