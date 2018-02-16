package org.selenium.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.utility.Utility;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public void enterUsername(String uname) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("loginPage_username_id"))).sendKeys(uname);
		
	}

	public void enterPassword(String pass) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("loginPage_password_id"))).sendKeys(pass);
		
	}
	
	public void clickSubmitButton() throws IOException
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValue("loginPage_submitButton_xpath"))).click();
	}
}
