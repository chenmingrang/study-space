package test;

import java.util.Date;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		String string = "0";
		System.out.println((int)string.charAt(0));
	}
	
	@Test
	public void test2(){
		long l= 630720000000L;
		System.out.println(new Date(l));
	}
}
