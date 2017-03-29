package com.codelovers.timeset.frontend;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codelovers.timeset.factory.LoginFactory;
import com.codelovers.timeset.object.Links;

public class LoginPage {
	WebDriver driver;
	LoginFactory lf;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		lf = new LoginFactory(driver);
		driver.manage().window().maximize();
		driver.get(Links.LOGIN);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}

	// Test kiểm tra Text
	@Test(groups = "UI")
	public void TC01_CheckPageTitle() throws Exception {
		String PageTitle = lf.getPageTitle();
		Assert.assertEquals(PageTitle, LoginFactory.PAGE_TITLE);
	}

	@Test(groups = "UI")
	public void TC02_CheckTextCompany() throws Exception {
		String CompanyName = lf.getCompanyName();
		Assert.assertEquals(CompanyName, LoginFactory.COMPANY_NAME);
	}

	@Test(groups = "UI")
	public void TC03_CheckTextForm() throws Exception {
		String FormName = lf.getFormName();
		Assert.assertEquals(FormName, LoginFactory.FORM_NAME);
	}

	@Test(groups = "UI")
	public void TC04_CheckTextPlacehodlerUsername() throws Exception {
		String PlacehodlerUsername = lf.getPlaceholderUsername();
		Assert.assertEquals(PlacehodlerUsername, LoginFactory.PLACEHOLDER_USERNAME);
	}

	@Test(groups = "UI")
	public void TC05_CheckTextPlacehodlerPW() throws Exception {
		String PlacehodlerPW = lf.getPlaceholderPW();
		Assert.assertEquals(PlacehodlerPW, LoginFactory.PLACEHOLDER_PASSWORD);
	}

	@Test(groups = "UI")
	public void TC06_CheckTextSubmitButton() throws Exception {
		String SubmitButton = lf.getSubmitButton();
		Assert.assertEquals(SubmitButton, LoginFactory.SUBMIT_BUTTON);
	}

	@Test(groups = "UI")
	public void TC07_CheckTextRememberLogin() throws Exception {
		String RememberLogin = lf.getRememberLogin();
		Assert.assertEquals(RememberLogin, LoginFactory.REMEMBER_LOGIN);
	}

	@Test(groups = "UI")
	public void TC08_CheckTextForgotPW() throws Exception {
		String ForgotPW = lf.getForgotPW();
		Assert.assertEquals(ForgotPW, LoginFactory.FORGOT_PASSWORD);
	}

	// Kiem tra chuc nang Login
	@Test (groups = "feature")
	public void TC09_RightUsernameWrongPassword() throws Exception{
		lf.sendKeysUsername("admin");
		lf.sendKeysPassword("admin");
		lf.clickSubmit();
	}
}
