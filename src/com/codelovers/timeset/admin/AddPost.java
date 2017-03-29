package com.codelovers.timeset.admin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.codelovers.timeset.factory.LoginFactory;
import com.codelovers.timeset.object.Links;

public class AddPost {
	WebDriver driver;
	LoginFactory lf;
	
	@BeforeClass
	public void setUp() throws Exception{
		driver = new ChromeDriver();
		lf = new LoginFactory(driver);
		driver.manage().window().maximize();
		driver.get(Links.LOGIN);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void quit() throws Exception{
		driver.quit();
	}
	
	@BeforeMethod
	public void LoginSuccess() throws Exception{
		lf.loginSuccessfully();
		driver.get(Links.NEW_POST);
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		driver.close();
	}
	
	// Test kiểm tra Text

	
	
}
