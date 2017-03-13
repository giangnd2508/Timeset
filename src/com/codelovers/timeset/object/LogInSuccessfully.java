package com.codelovers.timeset.object;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInSuccessfully {
	
	private static WebDriver driver;
	@Before
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void logIn() throws Exception {
		driver.get("http://timeset-test.codelovers.vn/login");
		driver.findElement(By.id("UserUsername")).sendKeys("admin");
		driver.findElement(By.id("UserPassword")).sendKeys("admin");
		driver.findElement(By.xpath("//[@id='UserAdminLoginForm']/div[3]/div[2]/button")).click();
				
	}
}