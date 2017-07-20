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
import com.codelovers.timeset.utilities.*;

public class A1ArticleListPage {

	private WebDriver driver;
	A1ArticleListFactory a1;
	A2AddPostFactory a2;
	LoginFactory lf;
	GenericMethods gm;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();

		a2 = new A2AddPostFactory(driver);
		lf = new LoginFactory(driver);
		a1 = new A1ArticleListFactory(driver);
		gm = new GenericMethods(driver);

		driver.manage().window().maximize();
		driver.get(Links.LOGIN);
		lf.loginSuccessfully();
		driver.navigate().to(Links.ALL_POSTS);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@AfterClass
	public void quitBrowser() throws Exception {
		driver.quit();
	}

	@Test(description = "Click Edit bài viết")
	public void A1_TC01() throws Exception {
		a1.clickEditItem1();
		gm.waitSeconds(3);
		a2.senkeysPostTitle("AAA");
		a2.clickSaveDraftButton();
		
		driver.navigate().to(Links.ALL_POSTS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		a1.selectDraftPost();
		a1.clickQueryPost();
		Assert.assertTrue(driver.getPageSource().contains("AAA"));
	}
}
