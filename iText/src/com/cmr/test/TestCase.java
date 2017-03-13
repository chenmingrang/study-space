package com.cmr.test;

import java.util.Random;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		String reg = "^(\\d|-){20}$";
		String str = "";
		String[] arr = {"-","1","2","3","4","5","6","7","8","9","0"};
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			int j = random.nextInt(11);
			str = str + arr[j];
		}
		System.out.println(str+".length="+str.length());
		System.out.println(str.matches(reg));
	}
}
