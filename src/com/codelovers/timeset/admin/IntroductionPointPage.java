package com.codelovers.timeset.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.codelovers.timeset.factory.*;
import com.codelovers.timeset.object.Links;

public class IntroductionPointPage {

	private WebDriver driver;
	IntroductionPointFactory ipf;
	LoginFactory lf;

	@BeforeSuite
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		ipf = new IntroductionPointFactory(driver);
		lf = new LoginFactory(driver);
		driver.get(Links.LOGIN);
		lf.loginSuccessfully();
		driver.navigate().to(Links.CAMPAIGN_POINT);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@AfterClass
	public void quitBrowser() throws Exception {
		driver.quit();
	}

	@Test(description = "Test giao diện ")
	public void IPP_TC01() throws Exception {
		String actualTitle = ipf.getPageTitle();
		Assert.assertEquals(actualTitle, IntroductionPointFactory.PAGE_TITLE);
		
		String actualBoxTitle = ipf.getPageTitle();
		Assert.assertEquals(actualBoxTitle, IntroductionPointFactory.BOX_PAGE_TITLE);
		
	}

}
