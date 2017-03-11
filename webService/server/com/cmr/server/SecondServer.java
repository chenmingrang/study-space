package com.cmr.server;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(serviceName="SecondService",targetNamespace="http://www.com.cn:80")
public class SecondServer {
	@WebMethod(operationName="HiService")
	@WebResult(name="HiReturn")
	public String sayHi(String name){
		System.out.println("sayHi() is called");
		return "你好"+name;
	}
	
	@WebMethod(exclude=true)
	public void sayHi2(String name){
		System.out.println("sayHi");
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:6789/hello", new SecondServer());
		System.out.println("secondServer is ready...");
	}
}
