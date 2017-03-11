package com.cmr.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class FirstService {

	public String sayHello(String name){
		System.out.println("sayHello()....");
		return getName()+name;
	}
	
	@WebMethod(exclude=true)
	public String getName(){
		return "hello ";
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9876/hello", new FirstService());
		System.out.println("server is ready....");
	}
}
