package com.pages.pom.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.report.ExtentReportUtils;
import com.test.pom.test.BaseTest;

public class LoginPage {

	@FindBy(name = "username")
	WebElement userNameTextBox;

	@FindBy(name = "password")
	WebElement passWordTextBox;

	@FindBy(css = "button[type='submit'].orangehrm-login-button")
	WebElement loginButton;

	public LoginPage() {
		PageFactory.initElements(BaseTest.driver, this);

	}

	Logger log = LogManager.getLogger(LoginPage.class);

	public void logintoorange(String username, String password) {
		userNameTextBox.sendKeys(username);
		log.info("Username entered");
		ExtentReportUtils.addStep("Username is entered");

		passWordTextBox.sendKeys(password);
		log.info("Password entered");

		ExtentReportUtils.addStep("Password is entered");

		loginButton.click();

		ExtentReportUtils.addStep("Submit button is clicked");
	}
}
