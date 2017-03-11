package com.cmr.client.wsimport;

public class Application {
	public static void main(String[] args) {
		FirstServiceService service=new FirstServiceService();
		FirstService firstService=service.getFirstServicePort();
		System.out.println(firstService.sayHello("Jack"));
	}
}
