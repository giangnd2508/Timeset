package com.codelovers.timeset.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory {
	WebDriver driver;

	@FindBy(xpath = "//b")
	WebElement companyName;

	@FindBy(xpath = "//p")
	WebElement formName;

	@FindBy(id = "UserUsername")
	WebElement username;

	@FindBy(id = "UserPassword")
	WebElement password;

	@FindBy(xpath = "//button")
	WebElement submitButton;

	@FindBy(xpath = "//form[@id='UserAdminLoginForm']/a")
	WebElement forgotPassword;

	@FindBy(xpath = "//form[@id='UserAdminLoginForm']//label")
	WebElement rememberLogin;

	public static final String PAGE_TITLE = "Login";
	public static final String PLACEHOLDER_USERNAME = "ユーザー名";
	public static final String PLACEHOLDER_PASSWORD = "パスワード";
	public static final String REMEMBER_LOGIN = "ユーザー名とパスワードを保存";
	public static final String COMPANY_NAME = "Caregiver Japan";
	public static final String FORM_NAME = "サインインしてください";
	public static final String SUBMIT_BUTTON = "サインイン";
	public static final String FORGOT_PASSWORD = "パスワード確認";

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

	public String getCompanyName() {
		String actualCompanyName = companyName.getText();
		return actualCompanyName;
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

	public String getSubmitButton() {
		String SubmitButton = submitButton.getText();
		return SubmitButton;
	}

	public String getRememberLogin() {
		String RememberLogin = rememberLogin.getText();
		return RememberLogin;
	}

	public String getForgotPW() {
		String ForgotPW = forgotPassword.getText();
		return ForgotPW;
	}

	public void loginSuccessfully() {
		username.sendKeys("admin");
		password.sendKeys("admin");
		submitButton.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
}
