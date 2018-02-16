package org.selenium.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.utility.Utility;

public class TestExecutionTrackerLogin {
	
	WebDriver driver;
	public TestExecutionTrackerLogin(WebDriver driver) {
		this.driver = driver;
	}
	public void enterUsername(String uname) throws IOException {
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("SHEEL");
				//name(Utility.fetchLocatorValue("Tracker_enterUsername_name"))).clear();
		
				//(Utility.fetchLocatorValue("Tracker_enterUsername_name"))).sendKeys(uname);		
	}
	
	public void enterPassword(String pass) throws IOException {
		//driver.findElement(By.name(Utility.fetchLocatorValue("Tracker_enterPassword_name"))).clear();
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("AAA");
		//driver.findElement(By.name(Utility.fetchLocatorValue("Tracker_enterPassword_name"))).sendKeys(pass);		
	}
	
		
	public void clickSubmitButton() throws IOException
	{
		driver.findElement(By.xpath("html/body/div[1]/form/input[3]")).click();
		//driver.findElement(By.xpath(Utility.fetchLocatorValue("Tracker_clickSubmitButton_xpath"))).click();
	}
}