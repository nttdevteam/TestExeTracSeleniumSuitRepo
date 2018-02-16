package org.selenium.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.base.driverInstance;
import org.selenium.pages.LoginPage;
import org.selenium.pages.TestExecutionTrackerLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC003_DevOpsSeleniumTest extends driverInstance {
	
	@Test//(dataProvider = "TrackerExcel")
	public void tc003_SeleniumTest() throws IOException {
		TestExecutionTrackerLogin tracker= new TestExecutionTrackerLogin(driver);
		tracker.enterUsername("SHEEL");
		tracker.enterPassword("AAA");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tracker.clickSubmitButton();
	}
	
	@DataProvider(name = "TrackerExcel")
	public Object[][] testDataGeneratorExcel() throws IOException {
		FileInputStream datafile = new FileInputStream("./TestData/TrackerTestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(datafile);
		XSSFSheet regSheet = workbook.getSheet("LoginData");
		int numberOfrows = regSheet.getPhysicalNumberOfRows();
		Object[][] testData = new Object[numberOfrows][2];

		for (int i = 0; i < numberOfrows; i++) {
			XSSFRow row = regSheet.getRow(i);
			XSSFCell uname = row.getCell(0);
			XSSFCell pass = row.getCell(1);
			testData[i][0] = uname.getStringCellValue();
			testData[i][1] = pass.getStringCellValue();
		}

		return testData;

	}

}
