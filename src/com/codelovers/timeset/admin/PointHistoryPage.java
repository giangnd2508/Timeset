package com.codelovers.timeset.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.codelovers.timeset.factory.*;
import com.codelovers.timeset.object.Links;

public class PointHistoryPage {

	private WebDriver driver;
	PointHistoryFactory phf;
	LoginFactory lf;

	@BeforeSuite
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		phf = new PointHistoryFactory(driver);
		lf = new LoginFactory(driver);
		driver.get(Links.LOGIN);
		lf.loginSuccessfully();
		driver.navigate().to(Links.POINT_HISTORY);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@AfterClass
	public void quitBrowser() throws Exception {
		driver.quit();
	}

	@Test(description = "Chọn Company1, Office 2, tháng 4-2017 ")
	public void PHP_TC01() throws Exception {
		phf.selectCompanyByIndex(1);
		phf.selectOfficeByIndex(1);
		phf.selectCalendar("2017-04");

	}

}
