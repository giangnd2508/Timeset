package com.codelovers.timeset.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codelovers.timeset.object.Items;
import com.codelovers.timeset.object.Links;

@Test
public class HomePage {

	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:/Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public static void tearDown() {
		driver.close();
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

	@Test
	public void TC1_checkTitleHomePage() throws Exception {
		driver.get(Links.HOMEPAGE);
		String actualTitle = driver.getTitle();
		String expectedTitle = "home";
		AssertJUnit.assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void TC2_checkTitleDailySettlement() throws Exception {
		driver.get(Links.DAILY_SETTLEMENT);
		String actualTitle = driver.getTitle();
		String expectedTitle = "日次決算";
		AssertJUnit.assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void TC3_checkTitleBudgetRanking() throws Exception {
		driver.get(Links.BUDGET_RANKING);
		String actualTitle = driver.getTitle();
		String expectedTitle = "予算達成ランキング";
		AssertJUnit.assertEquals(expectedTitle, actualTitle);
	}

	@Test
	public void TC4_checkTitleBudgetSale() throws Exception {
		driver.get(Links.BUDGET_SALE);
		String actualTitle = driver.getTitle();
		String expectedTitle = "昨年対比ランキング";
		AssertJUnit.assertEquals(expectedTitle, actualTitle);

	}

	@Test
	public void TC5_checkTitlePosts() throws Exception {
		driver.get(Links.POSTS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "投稿";
		AssertJUnit.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test
	public void TC6_checkTextAppear() throws Exception {
		driver.getPageSource().contains(Items.DAILY_SETTLEMENT);
		driver.getPageSource().contains(Items.BUDGET_RANKING);
		driver.getPageSource().contains(Items.BUDGET_SALE);
		driver.getPageSource().contains(Items.POSTS);		
	}
	
	
}
