package com.codelovers.timeset.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codelovers.timeset.object.Links;

public class AllPostsPage {
	private static WebDriver driver;

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public static void logIn() throws Exception {
		driver.get("https://daily.good-job.online/login");
		driver.findElement(By.id("UserUsername")).sendKeys("admin");
		driver.findElement(By.id("UserPassword")).sendKeys("admin");
		driver.findElement(By.xpath("*//button")).click();
	}
	
	@AfterMethod
	public void logOut() throws Exception {
		driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/ul/li[2]/div[2]/a")).click();
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
	}

	@Test
	public void TC1_checkTitle() throws Exception {
		driver.get(Links.ALL_POSTS);
		String actualTitle = driver.getTitle();
		int iTitleLength = driver.getTitle().length();
		System.out.println(actualTitle);
		System.out.println(iTitleLength);
	}
	

}