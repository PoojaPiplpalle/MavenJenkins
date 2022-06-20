package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {
	
	//suppose one testcase is dependent on other so HomePageTest() is dependent on loginTest() so if loginTest() gets failed then there is no use to execute HomePageTest() 
	//so we should use dependsOnMethods keyword.
	
	@Test
	public void loginTest() {
		
		
	System.out.println("login Test");
		
		int i=1/0; //this testcase will be failed then HomePageTest() will be skipped test case will not be considered.
	}
	
	@Test(dependsOnMethods="loginTest")
	public void HomePageTest() {
		
		
		System.out.println("HomePage Test");
	}
	@Test(enabled=false)
	public void SearchPageTest() {
		
		
		System.out.println("SearchPage Test");
	}
	
	@Test
	public void RegPageTest() {
		
		System.out.println("RegPage Test");
	}
}
