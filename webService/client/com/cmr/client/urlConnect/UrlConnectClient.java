package com.cmr.client.urlConnect;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectClient {
	public static void main(String[] args) throws Exception{
		URL wsUrl = new URL("http://127.0.0.1:9876/hello");
		HttpURLConnection conn=(HttpURLConnection) wsUrl.openConnection();
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		//soap版本1
		conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
		OutputStream os=conn.getOutputStream();
		//请求体
		String soap = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:q0='http://server.cmr.com/' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'><soapenv:Body>"+
                       "<q0:sayHello><arg0>Tom</arg0></q0:sayHello></soapenv:Body></soapenv:Envelope";
		
		os.write(soap.getBytes());
		InputStream is=conn.getInputStream();
		byte[] bytes=new byte[1024];
		int len =0;
		String str="";
		while ((len=is.read(bytes))!=-1) {
			String str1=new String(bytes, 0, len,"UTF-8");
			str+=str1;
		}
		System.out.println(str);
		is.close();
		os.close();
		conn.disconnect();
	}
}
