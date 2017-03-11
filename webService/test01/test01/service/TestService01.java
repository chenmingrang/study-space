package test01.service;

import javax.xml.ws.Endpoint;

public class TestService01 {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:7777/test01", new MyServiceImpl());
		System.out.println("server is ready...");
	}
}
