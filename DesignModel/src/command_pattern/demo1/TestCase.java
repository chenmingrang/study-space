package command_pattern.demo1;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		System.out.println("====客户要求增加一项需求====");
		Group rg=new RequirementGroup();
		rg.find();
		rg.add();
		rg.plan();
	}
	
	@Test
	public void test2(){
		System.out.println("====客户要求删除一个页面====");
		Group pg=new PageGroup();
		pg.find();
		pg.delete();
		pg.plan();
	}
}
