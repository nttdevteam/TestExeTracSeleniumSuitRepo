package org.selenium.TestCases;

import java.io.IOException;

import org.selenium.base.driverInstance;
import org.selenium.pages.LoginPage;
import org.testng.annotations.Test;

public class TC001_ValidateLoginFunctionality extends driverInstance {
	
	@Test
	public void tc001_LinkedInReg() throws IOException {
		LoginPage login= new LoginPage(driver);
		login.enterUsername("uname");
		login.enterPassword("pass");
		login.clickSubmitButton();
	}

}
