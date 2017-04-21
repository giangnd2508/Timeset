package com.codelovers.timeset.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codelovers.timeset.factory.A2AddPostFactory;
import com.codelovers.timeset.factory.LoginFactory;
import com.codelovers.timeset.object.Links;

public class A2AddPostPage {
	private WebDriver driver;
	A2AddPostFactory a2;
	LoginFactory lf;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		a2 = new A2AddPostFactory(driver);
		lf = new LoginFactory(driver);
		driver.get(Links.LOGIN);
		lf.loginSuccessfully();
		driver.navigate().to(Links.NEW_POST);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}
	@AfterClass
	public void quitBrowser() throws Exception{
		driver.quit();
	}

	@Test(description = "Post bài mà bỏ trống tất cả các trường")
	public void A2_TC01() throws Exception {
		a2.clickPublishButton();
		Assert.assertEquals(a2.getPageTitle(), A2AddPostFactory.PAGE_TITLE);
	}

	@Test(description = "Post bài mà bỏ trống trường tiêu đề")
	public void A2_TC02() throws Exception {
		a2.senkeysDescription(A2AddPostFactory.DATA_256_CHAR);
		a2.senkeysContent(A2AddPostFactory.DATA_100_CHAR);
		a2.clickPublishButton();
		Assert.assertEquals(a2.getPageTitle(), A2AddPostFactory.PAGE_TITLE);
	}
	
	@Test(description = "Post bài mà bỏ trống trường description")
	public void A2_TC03() throws Exception {
		a2.senkeysPostTitle(A2AddPostFactory.DATA_100_CHAR);
		a2.senkeysContent(A2AddPostFactory.DATA_100_CHAR);
		a2.clickPublishButton();
		Assert.assertEquals(a2.getPageTitle(), A2AddPostFactory.PAGE_TITLE);
	}
	
}
