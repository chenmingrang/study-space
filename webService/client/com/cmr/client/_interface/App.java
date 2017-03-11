package com.cmr.client._interface;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class App {
	public static void main(String[] args) throws Exception {
		URL wsdlUrl = new URL("http://localhost:9876/hello?wsdl");
		Service s = Service.create(wsdlUrl, new QName("http://server.cmr.com/","FirstServiceService"));
		FirstService hs = s.getPort(FirstService.class);
		String ret = hs.sayHello("zhangsan");
		System.out.println(ret);
	}
}
