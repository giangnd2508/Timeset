package com.codelovers.timeset.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private static WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void logIn() throws Exception {
		driver.get("https://daily.good-job.online/login");
		driver.findElement(By.id("UserUsername")).sendKeys("admin");
		driver.findElement(By.id("UserPassword")).sendKeys("admin");
		driver.findElement(By.xpath("*//button")).click();
	}

	@AfterMethod
	public void logOut() throws Exception {
		driver.findElement(By.xpath("//section/a")).click();
		driver.findElement(By.xpath("//section/ul/li[3]/a")).click();
	}

}
