package org.selenium.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.utility.Utility;

public class RegLinkedIn {

	WebDriver driver;
	public RegLinkedIn(WebDriver driver) {
		this.driver = driver;
	}
	public void enterFname(String fname) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("LinkedIn_Fname_id"))).sendKeys(fname);
		
	}

	public void enterlName(String lname) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("LinkedIn_Lname_id"))).sendKeys(lname);
		
	}
	
	public void enterEmail(String email) throws IOException {
		driver.findElement(By.id(Utility.fetchLocatorValue("LinkedIn_Email_id"))).sendKeys(email);
		
	}
	
	public void clickJoinNow() throws IOException
	{
		driver.findElement(By.id(Utility.fetchLocatorValue("LinkedIn_JoinNowBTN_id"))).click();
	}
}