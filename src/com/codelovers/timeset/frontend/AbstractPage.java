package com.codelovers.timeset.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codelovers.timeset.object.Links;

public class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void logIn() throws Exception {
		driver.get(Links.LOGIN);
		driver.findElement(By.id("UserPassword")).sendKeys("admin");
		driver.findElement(By.xpath("*//button")).click();
	}

	public void logOut() throws Exception {
		driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/header/nav/div/ul/li/ul/li[2]/div[2]/a")).click();
	}

	public void tearDown() {
		driver.close();
	}

	public HomePage navigatetoHomepage() {
		driver.navigate().to(Links.ADMIN);
		return new HomePage(driver);
	}
}
