package com.codelovers.timeset.frontend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.codelovers.timeset.factory.LoginFactory;
import com.codelovers.timeset.object.Links;

public class LogInPage {
	WebDriver driver;
	LoginFactory lf;

	@BeforeClass
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		lf = new LoginFactory(driver);
		driver.get(Links.LOGIN);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	@AfterClass
	public void quitBrowser() throws Exception {
		driver.quit();
	}

//	@Test(description = "Check Text")
//	public void LG_UI_01() throws Exception {
//		String PageTitle = lf.getPageTitle();
//		Assert.assertEquals(PageTitle, LoginFactory.PAGE_TITLE);
//
//		String FormName = lf.getFormName();
//		Assert.assertEquals(FormName, LoginFactory.FORM_NAME);
//
//		String PlacehodlerUsername = lf.getPlaceholderUsername();
//		Assert.assertEquals(PlacehodlerUsername, LoginFactory.PLACEHOLDER_USERNAME);
//
//		String PlacehodlerPW = lf.getPlaceholderPW();
//		Assert.assertEquals(PlacehodlerPW, LoginFactory.PLACEHOLDER_PASSWORD);
//
//		String SubmitButton = lf.getSubmitButton();
//		Assert.assertEquals(SubmitButton, LoginFactory.SUBMIT_BUTTON);
//
//		String RememberLogin = lf.getRememberLogin();
//		Assert.assertEquals(RememberLogin, LoginFactory.REMEMBER_LOGIN);
//
//		String ForgotPW = lf.getForgotPW();
//		Assert.assertEquals(ForgotPW, LoginFactory.FORGOT_PASSWORD);
//
//		String Terms = lf.getTerms();
//		Assert.assertEquals(Terms, LoginFactory.TERMS);
//
//		 String Privacy = lf.getTerms();
//		 Assert.assertEquals(Privacy, LoginFactory.TERMS);
//
//	}

	@Test(description = "Login without ID and Pass")
	private void TC_001() throws Exception {
		lf.login("", "");
		lf.assertPageTitle();
	}

}
