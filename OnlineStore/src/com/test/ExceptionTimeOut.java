package com.test;

import org.testng.annotations.Test;

public class ExceptionTimeOut {

	/*@Test(invocationTimeOut=2000,expectedExceptions=NumberFormatException.class)
	public void infiniteLooptest() {
		
		int i=1;
		while(i==1) {
			
			System.out.println(i);
		}//will excute infinte times so to avoid infinte loop we use invocationTimeOut and if im expecting exception so dont terminate the testcase.
		//use expectedExceptions=NumberFormatException.class
	}*/
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void test1() {
		
		String x="100A";
		Integer.parseInt(x);
	}
}
