package test01.service;

import javax.jws.WebService;

@WebService(endpointInterface="test01.service.IMyService")
public class MyServiceImpl implements IMyService{

	@Override
	public int plus(int a, int b) {
		System.out.println("plus()....");
		return a+b;
	}

	@Override
	public int minus(int a, int b) {
		System.out.println("minus()....");
		return a-b;
	}

	@Override
	public Student query(int id) {
		System.out.println("query()....");
		Student student=new Student();
		student.setId(id);
		//模拟查询数据库
		student.setName("Tommy");
		student.setAddress("English");
		return student;
	}

}
