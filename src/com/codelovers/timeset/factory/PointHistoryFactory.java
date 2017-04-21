package com.codelovers.timeset.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PointHistoryFactory {
	WebDriver driver;

	@FindBy(xpath = "//h3[@class = 'box-title']")
	WebElement boxPageTitle;

	@FindBy(id = "EmployeeCompany")
	WebElement companies;

	@FindBy(id = "office_id")
	WebElement offices;

	@FindBy(id = "monthYearSelectPoint")
	WebElement calendar;

	public static final String BOX_PAGE_TITLE = "";

	public PointHistoryFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {
		String actualPageTitle = driver.getTitle();
		return actualPageTitle;
	}

	public String getBoxTitle() {
		String BoxTitle = boxPageTitle.getText();
		return BoxTitle;
	}

	public void selectCompanyByIndex(int index) {
		Select selection = new Select(companies);
		selection.selectByIndex(index);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void selectCompanyByValue(String value) {
		Select selection = new Select(companies);
		selection.selectByValue(value);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void selectOfficeByIndex(int index) {
		Select selection = new Select(offices);
		selection.selectByIndex(index);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void selectOfficeByValue(String value) {
		Select selection = new Select(offices);
		selection.selectByValue(value);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public void selectCalendar(String year_month) {
		calendar.click();
		calendar.clear();
		calendar.sendKeys(year_month);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
}
