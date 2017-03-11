package decorator_pattern.demo1;

import org.junit.Test;

public class Father {
	@Test
	public void test1() {
		SchoolReport sr = new FourthGradeSchoolReport();
		sr.report();
		sr.sign("不通过！");
	}

	@Test
	public void test2() {
		SchoolReport sr = new SugarFourthGradeSchoolReport();
		sr.report();
		sr.sign("张三");
	}
	
	@Test
	public void test3(){
		SchoolReport sr = new FourthGradeSchoolReport();
		//第一次装饰
		sr = new SortDecorator(sr);
		//第二次装饰
		sr = new HighScoreDecorator(sr);
		sr.report();
	}
}
