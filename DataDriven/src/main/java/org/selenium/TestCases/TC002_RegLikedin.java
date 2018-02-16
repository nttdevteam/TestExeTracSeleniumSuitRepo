package org.selenium.TestCases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.selenium.base.driverInstance;
import org.selenium.pages.LoginPage;
import org.selenium.pages.RegLinkedIn;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC002_RegLikedin extends driverInstance {

	@Test(dataProvider = "Excel")
	public void tc002_LinkedInReg(String fname, String lname, String email) throws IOException {
		RegLinkedIn regLink = new RegLinkedIn(driver);
		regLink.enterFname(fname);
		regLink.enterlName(lname);
		regLink.enterEmail(email);
		regLink.clickJoinNow();
	}

	/*
	 * @DataProvider (name = "TC002") public Object [][] testDataGenerator(){ Object
	 * [][] data =
	 * {{"fname1","lname1","email1"},{"fname2","lname2","email2"},{"fname3","lname3"
	 * ,"email3"}} ; return data; }
	 */

	@DataProvider(name = "Excel")
	public Object[][] testDataGeneratorExcel() throws IOException {
		FileInputStream datafile = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(datafile);
		XSSFSheet regSheet = workbook.getSheet("Registration");
		int numberOfrows = regSheet.getPhysicalNumberOfRows();
		Object[][] testData = new Object[numberOfrows][3];

		for (int i = 0; i < numberOfrows; i++) {
			XSSFRow row = regSheet.getRow(i);
			XSSFCell fname = row.getCell(0);
			XSSFCell lname = row.getCell(1);
			XSSFCell email = row.getCell(2);
			testData[i][0] = fname.getStringCellValue();
			testData[i][1] = lname.getStringCellValue();
			testData[i][2] = email.getStringCellValue();
		}

		return testData;

	}
}
