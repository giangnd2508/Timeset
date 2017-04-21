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

public class CampaignPointPage {

	private WebDriver driver;
	CampaignPointFactory cpf;
	LoginFactory lf;

	@BeforeSuite
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		cpf = new CampaignPointFactory(driver);
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

	@Test(description = "Test giao diện: check text")
	public void PHP_TC01() throws Exception {
		String actualTitle = cpf.getPageTitle();
		Assert.assertEquals(actualTitle, CampaignPointFactory.PAGE_TITLE);
		
		String actualBoxTitle = cpf.getPageTitle();
		Assert.assertEquals(actualBoxTitle, CampaignPointFactory.BOX_PAGE_TITLE);
	}

}
