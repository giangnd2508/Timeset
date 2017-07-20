package com.codelovers.timeset.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginFactory {
	WebDriver driver;

	@FindBy(xpath = "//p")
	WebElement formName;

	@FindBy(id = "UserUsername")
	WebElement username;

	@FindBy(id = "UserPassword")
	WebElement password;

	@FindBy(xpath = "//form[@id='UserAdminLoginForm']//label")
	WebElement rememberLogin;

	@FindBy(xpath = "//form[@id='UserAdminLoginForm']//button")
	WebElement submitButton;

	@FindBy(xpath = "//*[@id='UserAdminLoginForm']//a[@href='/forgot_password']")
	WebElement forgotPassword;

	@FindBy(xpath = "//*[@id='UserAdminLoginForm']//a[@href='/terms.html']")
	WebElement terms;

//	@FindBy(xpath = "//*[@id='UserAdminLoginForm']//a[@href='/privacy.html']")
//	WebElement privacy;

	public static final String PAGE_TITLE = "Login";
	public static final String PLACEHOLDER_USERNAME = "ユーザー名";
	public static final String PLACEHOLDER_PASSWORD = "パスワード";
	public static final String REMEMBER_LOGIN = "ユーザー名とパスワードを保存";
	public static final String FORM_NAME = "サインインしてください";
	public static final String SUBMIT_BUTTON = "利用規約に同意してサインイン";
	public static final String FORGOT_PASSWORD = "パスワードを忘れました";
	public static final String TERMS = "利用規約";
	public static final String PRIVACY = "プライバシーポリシー";

	public LoginFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Chuc nang Login
	public void sendKeysUsername(String value) {
		username.clear();
		username.sendKeys(value);
	}

	public void sendKeysPassword(String value) {
		password.clear();
		password.sendKeys(value);
	}

	public void clickSubmit() {
		submitButton.click();
	}

	// Click chuyen trang
	public void clickForgotPassword() {
		forgotPassword.click();
	}

	public void clickRememberLogin() {
		rememberLogin.click();
	}

	// Phuong thuc get Text
	public String getPageTitle() {
		String actualPageTitle = driver.getTitle();
		return actualPageTitle;
	}

	public String getFormName() {
		String actualFormName = formName.getText();
		return actualFormName;
	}

	public String getPlaceholderUsername() {
		String actualPlaceholderUsername = username.getAttribute("placeholder");
		return actualPlaceholderUsername;
	}

	public String getPlaceholderPW() {
		String actualPlaceholderPW = password.getAttribute("placeholder");
		return actualPlaceholderPW;
	}

	public String getRememberLogin() {
		String RememberLogin = rememberLogin.getText();
		return RememberLogin;
	}

	public String getSubmitButton() {
		String SubmitButton = submitButton.getText();
		return SubmitButton;
	}

	public String getForgotPW() {
		String ForgotPW = forgotPassword.getText();
		return ForgotPW;
	}

	public String getTerms() {
		String Terms = terms.getText();
		return Terms;
	}

//	public String getPrivacy() {
//		String Privacy = privacy.getText();
//		return Privacy;
//	}

	public void loginSuccessfully() {
		username.sendKeys("giang123");
		password.sendKeys("12345678");
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public void login(String userName, String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	public void assertPageTitle() {
		String PageTitle = driver.getTitle();
		Assert.assertEquals(PageTitle, LoginFactory.PAGE_TITLE);
	}
}
