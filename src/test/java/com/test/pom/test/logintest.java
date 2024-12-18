package com.test.pom.test;

import org.testng.annotations.Test;

import com.pages.pom.test.LoginPage;

public class logintest extends BaseTest{
	
	@Test
	public void loginwithvalidusername() {
		LoginPage login = new LoginPage();
		login.logintoorange("Admin","admin123");
	}
}
