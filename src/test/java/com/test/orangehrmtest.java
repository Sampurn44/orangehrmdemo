package com.test;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.LogManager;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.utility.excelutility;

import io.opentelemetry.api.logs.Logger;

public class orangehrmtest {
	ChromeDriver driver;
	 // Initialize WebDriverWait
   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
   
   @Test(priority=1)
   ExtentReportUtils
	
   public void logintest() throws InvalidFormatException, IOException {
   	 if (driver == null) { // Initialize only if driver is null
   		 System.setProperty("webdriver.chrome.driver",
   	                "D:\\RecruitCRM\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        }
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       
       
       
       
       // Login process
       WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
       emailElement.sendKeys(excelutility.getTestData(1, 0));

       WebElement passElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
       passElement.sendKeys(excelutility.getTestData(1, 1));

       WebElement loginElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit'].orangehrm-login-button")));
       loginElement.click();

       wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));


	}
	@Test(priority=2,dependsOnMethods = "logintest")
	public void directory() {
		
	        // Navigate to the Reports section
	        WebElement reportbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[.//span[text()='Directory']]")));
	        reportbtn.click();
	        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']//input[@placeholder='Type for hints...']")));
	    	inputField.sendKeys("Peter Mac Anderson");
	    	
	    	
	        // Add further actions for the report as needed
	       // wait.until(ExpectedConditions.urlToBe("https://neo-mr.recruitcrm.io/v1/report"));
	   
	}
	@Test(priority=3,dependsOnMethods = "logintest")
	public void logout() {
		WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='oxd-userdropdown-img' and @alt='profile picture']")));
		dashboard.click();
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/web/index.php/auth/logout']")));
		logout.click();
		
	}
	
}
