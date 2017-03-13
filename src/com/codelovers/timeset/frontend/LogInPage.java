package com.codelovers.timeset.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codelovers.timeset.object.Links;

public class LogInPage {
	private static WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

//	@AfterClass
//	public static void tearDown() {
//		driver.close();
//	}
	
	@Test
	public void TC1_LogInWithBlankField() throws Exception{
		driver.get(Links.LOGIN);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualAlert = "ユーザー名かパスワードが無効です。";
		String alert = driver.findElement(By.xpath("//div[contains(text(),'ユーザー名かパスワードが無効です。')]")).getText();
		Assert.assertEquals(alert, actualAlert);
	}
}
