package com.codelovers.timeset.admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codelovers.timeset.factory.A1ArticleListFactory;
import com.codelovers.timeset.factory.A2AddPostFactory;
import com.codelovers.timeset.factory.LoginFactory;
import com.codelovers.timeset.object.Links;

public class A2AddPostPage {
	private WebDriver driver;
	A1ArticleListFactory a1;
	A2AddPostFactory a2;
	LoginFactory lf;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		
		a2 = new A2AddPostFactory(driver);
		lf = new LoginFactory(driver);
		a1 = new A1ArticleListFactory(driver);
		
		driver.manage().window().maximize();
		driver.get(Links.LOGIN);
		lf.loginSuccessfully();
		driver.navigate().to(Links.NEW_POST);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@AfterClass
	public void quitBrowser() throws Exception {
		driver.quit();
	}

	// @Test(description = "Post bài mà bỏ trống tất cả các trường")
	// public void A2_TC01() throws Exception {
	// a2.clickPublishButton();
	// Assert.assertEquals(a2.getPageTitle(), A2AddPostFactory.PAGE_TITLE);
	// }
	//
	// @Test(description = "Post bài mà bỏ trống trường tiêu đề")
	// public void A2_TC02() throws Exception {
	// a2.senkeysDescription(A2AddPostFactory.DATA_256_CHAR);
	// a2.senkeysContent(A2AddPostFactory.DATA_100_CHAR);
	// a2.clickPublishButton();
	// Assert.assertEquals(a2.getPageTitle(), A2AddPostFactory.PAGE_TITLE);
	// }
	//
	// @Test(description = "Post bài mà bỏ trống trường description")
	// public void A2_TC03() throws Exception {
	// a2.senkeysPostTitle(A2AddPostFactory.DATA_100_CHAR);
	// a2.senkeysContent(A2AddPostFactory.DATA_100_CHAR);
	// a2.clickPublishButton();
	// Assert.assertEquals(a2.getPageTitle(), A2AddPostFactory.PAGE_TITLE);
	// }
	//
	// @Test(description = "Post bài mà bỏ trống trường Content")
	// public void A2_TC04() throws Exception {
	// a2.senkeysPostTitle(A2AddPostFactory.DATA_100_CHAR);
	// a2.senkeysDescription(A2AddPostFactory.DATA_256_CHAR);
	// a2.clickPublishButton();
	// Assert.assertEquals(a2.getPageTitle(), A2AddPostFactory.PAGE_TITLE);
	// }

	@Test(description = "Post bài lưu nháp")
	public void A2_TC05() throws Exception {
		a2.senkeysPostTitle(A2AddPostFactory.DATA_100_CHAR);
		a2.senkeysDescription(A2AddPostFactory.DATA_256_CHAR);
		a2.senkeysContent(A2AddPostFactory.DATA_100_CHAR);
		a2.clickSaveDraftButton();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.navigate().to(Links.ALL_POSTS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		a1.selectDraftPost();
		a1.clickQueryPost();
		Assert.assertTrue(driver.getPageSource().contains(A2AddPostFactory.DATA_100_CHAR));
	}

}
