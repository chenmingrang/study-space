package test01.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

public class TestClient {
	@Test
	public void test01() {
		try {
			//创建访问wsdl服务地址的url
			URL url = new URL("http://localhost:7777/test01?wsdl");
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
	
	@Test
	public void test02(){
		URL url;
		try {
			url = new URL("http://localhost:7777/test01?wsdl");
			QName sname = new QName("http://service.test01/", "MyServiceImplService");
//			MyServiceImplService service=new MyServiceImplService(url, sname);
		    MyServiceImplService service=new MyServiceImplService();
			IMyService myService=service.getPort(IMyService.class);
			System.out.println(myService.plus(22, 21));
			System.out.println(myService.query(22));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		//通过Qname指明服务的具体信息
	}
}
