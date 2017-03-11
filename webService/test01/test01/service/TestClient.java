package test01.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TestClient {
	public static void main(String[] args) {
		try {
			//创建访问wsdl服务地址的url
			URL url = new URL("http://localhost:7777/test01");
			//通过Qname指明服务的具体信息
			QName sname = new QName("http://service.test01/", "MyServiceImplService");
			//创建服务
			Service service = Service.create(url,sname);
			//实现接口
			IMyService ms = service.getPort(IMyService.class);
			System.out.println(ms.minus(12,33));
			System.out.println(ms.query(22));
			//以上服务有问题，依然依赖于IMyServie接口
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
