package org.selenium.base;

import java.awt.Window;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.selenium.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class driverInstance {
	public WebDriver driver;

@BeforeMethod
	public void initiateDriverInstance() throws IOException {
		if (Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./Driver/internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(Utility.fetchPropertyValue("applicationURL").toString());
	}

/*@AfterMethod
	public void closeDriverInstance() {
		driver.quit();
	}
*/
}
